import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.FileWriter;
import java.io.IOException;

public class opensea {
    public static void main(String[] args) {
        try {
            // Tạo một URL object với URL của API
            URL url = new URL("https://opensea.io/__api/graphql/");

            // Mở kết nối đến URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Đặt phương thức yêu cầu thành POST
            connection.setRequestMethod("POST");

            // Bật cho phép việc gửi dữ liệu trong yêu cầu
            connection.setDoOutput(true);

            // Đặt Header cho việc gửi dữ liệu dưới dạng JSON
            connection.setRequestProperty("Content-Type", "application/json");

            // Dữ liệu JSON bạn muốn gửi
            String jsonData = "{\n" +
                    "  \"id\": \"RankingsPageTrendingQuery\",\n" +
                    "  \"query\": \"query RankingsPageTrendingQuery(\\n  $chain: [ChainScalar!]\\n  $count: Int!\\n  $cursor: String\\n  $categories: [CategoryV2Slug!]!\\n  $eligibleCount: Int!\\n  $trendingCollectionsSortBy: TrendingCollectionSort\\n  $timeWindow: StatsTimeWindow\\n  $floorPricePercentChange: Boolean!\\n) {\\n  ...RankingsPageTrending_data\\n}\\n\\nfragment RankingsPageTrending_data on Query {\\n  trendingCollectionsByCategory(after: $cursor, chains: $chain, first: $count, sortBy: $trendingCollectionsSortBy, categories: $categories, topCollectionLimit: $eligibleCount) {\\n    edges {\\n      node {\\n        createdDate\\n        name\\n        slug\\n        logo\\n        isVerified\\n        relayId\\n        ...StatsCollectionCell_collection\\n        ...collection_url\\n        statsV2 {\\n          totalQuantity\\n        }\\n        windowCollectionStats(statsTimeWindow: $timeWindow) {\\n          floorPrice {\\n            unit\\n            eth\\n            symbol\\n          }\\n          numOwners\\n          totalSupply\\n          totalListed\\n          numOfSales\\n          volumeChange\\n          volume {\\n            unit\\n            eth\\n            symbol\\n          }\\n        }\\n        floorPricePercentChange(statsTimeWindow: $timeWindow) @include(if: $floorPricePercentChange)\\n        id\\n        __typename\\n      }\\n      cursor\\n    }\\n    pageInfo {\\n      endCursor\\n      hasNextPage\\n    }\\n  }\\n}\\n\\nfragment StatsCollectionCell_collection on CollectionType {\\n  name\\n  logo\\n  isVerified\\n  slug\\n}\\n\\nfragment collection_url on CollectionType {\\n  slug\\n  isCategory\\n}\\n\",\n" +
                    "  \"variables\": {\n" +
                    "    \"chain\": null,\n" +
                    "    \"count\": 100,\n" +
                    "    \"cursor\": null,\n" +
                    "    \"categories\": [],\n" +
                    "    \"eligibleCount\": 500,\n" +
                    "    \"trendingCollectionsSortBy\": \"ONE_DAY_SALES\",\n" +
                    "    \"timeWindow\": \"ONE_DAY\",\n" +
                    "    \"floorPricePercentChange\": true\n" +
                    "  }\n" +
                    "}";

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
            try (FileWriter fileWriter = new FileWriter("binance.json")) {
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


