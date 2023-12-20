package CrawlData.NftFloor.OpenSea;

import Model.NftFloor.BinanceNft;
import Model.NftFloor.OpenSeaNft;
import com.google.gson.Gson;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;




public class OpenSeaJsonReader {
    public static List<OpenSeaNft> readOpenSeaJson(String filePath) {
        List<OpenSeaNft> openSeaNftList = new ArrayList<>();

        try {
            // Sử dụng Gson để đọc file JSON
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(new FileReader(filePath), JsonArray.class);

            // Duyệt qua mảng JSON và tạo đối tượng từ mỗi phần tử
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                OpenSeaNft openSeaNft = gson.fromJson(jsonObject, OpenSeaNft.class);

                // In thông tin của đối tượng (bạn có thể xóa phần in này nếu không cần)
                //System.out.println(openSeaNft.getName());
                //System.out.println(openSeaNft.getFloorPrice());

                // Thêm đối tượng OpenSeaNft vào danh sách
                openSeaNftList.add(openSeaNft);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Trả về danh sách OpenSeaNft
        return openSeaNftList;
    }

}

