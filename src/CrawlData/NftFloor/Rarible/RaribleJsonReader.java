package CrawlData.NftFloor.Rarible;

import Model.NftFloor.BinanceNft;
import Model.NftFloor.RaribleNft;
import com.google.gson.*;
import org.json.JSONArray;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class RaribleData {
    private int total;
    private List<RaribleNft> rows;

    public int getTotal() {
        return total;
    }

    public List<RaribleNft> getRows() {
        return rows;
    }
}



public class RaribleJsonReader {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("Data//Rarible.json")) {
            // Khởi tạo Gson
            Gson gson = new GsonBuilder().create();
            // Chuyển đổi file JSON thành một mảng đối tượng Java
            // Parse JSON file
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            List<RaribleNft> raribleNfts = new ArrayList<>();

            // Truy cập danh sách các NFT
            for (int i = 1; i < 3; i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                // Extract necessary properties from JSON object
                String collectionId = jsonObject.getAsJsonObject("collection").get("id").getAsString();
                String coverUrl = jsonObject.getAsJsonObject("collection").get("cover").getAsString();
                String title = jsonObject.get("name").getAsString();
                String network = jsonObject.getAsJsonObject("collection").get("blockchain").getAsString();
                // ... extract other properties ...

                // Create an object and add it to the list
                RaribleNft raribleNft = new RaribleNft();
                raribleNft.setCollectionId(collectionId);
                raribleNft.setCoverUrl(coverUrl);
                raribleNft.setTitle(title);
                raribleNft.setNetwork(network);
            }

            // Print information of each object
            for (RaribleNft nft : raribleNfts) {
                System.out.println("Title: " + nft.getTitle());
                System.out.println("Collection ID: " + nft.getCollectionId());
                System.out.println("Cover URL: " + nft.getCoverUrl());
                System.out.println("Network: " + nft.getNetwork());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

