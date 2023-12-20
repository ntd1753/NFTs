package CrawlData.NftFloor.Binance;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class BinanceAPICall {
    public static void main(String[] args) {
        try {
            // Tạo một URL object với URL của API
            URL url = new URL("https://www.binance.com/bapi/nft/v1/friendly/nft/ranking/trend-collection");

            // Mở kết nối đến URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Đặt phương thức yêu cầu thành POST
            connection.setRequestMethod("POST");

            // Bật cho phép việc gửi dữ liệu trong yêu cầu
            connection.setDoOutput(true);

            // Đặt Header cho việc gửi dữ liệu dưới dạng JSON
            connection.setRequestProperty("Content-Type", "application/json");

            // Dữ liệu JSON bạn muốn gửi
            String jsonData = "{"
                    + "\"network\": \"ALL\","
                    + "\"period\": \"1H\","
                    + "\"sortType\": \"volumeDesc\","
                    + "\"page\": 1,"
                    + "\"rows\": 100"
                    + "}";

            // Ghi dữ liệu JSON vào luồng ghi của yêu cầu
            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes(jsonData);

            // Đóng luồng ghi
            dataOutputStream.close();

            // Nhận mã phản hồi
//            int responseCode = connection.getResponseCode();
            // Đọc phản hồi từ API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
            try (FileWriter fileWriter = new FileWriter("Data//Binance.json")) {
                fileWriter.write(response.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Đóng kết nối
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


