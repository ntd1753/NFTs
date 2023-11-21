import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.util.List;
class NFTData {
    private String code;
    private String message;
    private String messageDetail;
    private Data data;
    private boolean success;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public Data getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }
}

class Data {
    private int total;
    private List<NFT> rows;

    public int getTotal() {
        return total;
    }

    public List<NFT> getRows() {
        return rows;
    }
}

class NFT {
    private String collectionId;
    private String coverUrl;
    private String title;
    private String network;
    private String volume;
    private String volumeRate;
    private int ownersCount;
    private int itemsCount;
    private String listedCount;
    private String floorPrice;
    private String floorPriceRate;
    private int verified;

    public String getCollectionId() {
        return collectionId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getNetwork() {
        return network;
    }

    public String getVolume() {
        return volume;
    }

    public String getVolumeRate() {
        return volumeRate;
    }

    public int getOwnersCount() {
        return ownersCount;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public String getListedCount() {
        return listedCount;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public String getFloorPriceRate() {
        return floorPriceRate;
    }

    public int getVerified() {
        return verified;
    }
}

public class JsonReader {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("binance.json")) {
            // Khởi tạo Gson
            Gson gson = new GsonBuilder().create();

            // Đọc tệp JSON và chuyển đổi nó thành đối tượng NFTData
            NFTData nftData = gson.fromJson(reader, NFTData.class);

            // Truy cập các thuộc tính của đối tượng NFTData
            System.out.println("Code: " + nftData.getCode());
            System.out.println("Total: " + nftData.getData().getTotal());

            // Truy cập danh sách các NFT
            List<NFT> nftList = nftData.getData().getRows();

            for (NFT nft : nftList) {
                System.out.println("Title: " + nft.getTitle());
                System.out.println("Collection ID: " + nft.getCollectionId());
                System.out.println("Cover URL: " + nft.getCoverUrl());
                System.out.println("Network: " + nft.getNetwork());
                System.out.println("Volume: " + nft.getVolume());
                System.out.println("Volume Rate: " + nft.getVolumeRate());
                System.out.println("Owners Count: " + nft.getOwnersCount());
                System.out.println("Items Count: " + nft.getItemsCount());
                System.out.println("Listed Count: " + nft.getListedCount());
                System.out.println("Floor Price: " + nft.getFloorPrice());
                System.out.println("Floor Price Rate: " + nft.getFloorPriceRate());
                System.out.println("Verified: " + nft.getVerified());
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

