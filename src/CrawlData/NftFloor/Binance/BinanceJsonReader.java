package CrawlData.NftFloor.Binance;

import Model.NftFloor.BinanceNft;
import Model.NftFloor.OpenSeaNft;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.util.List;

class JsonData {
    private String code;
    private String message;
    private String messageDetail;

    private BinanceData data;
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

    public BinanceData getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }
}

class BinanceData {
    private int total;
    private List<BinanceNft> rows;

    public int getTotal() {
        return total;
    }

    public List<BinanceNft> getRows() {
        return rows;
    }
}



public class BinanceJsonReader {
    public static List<BinanceNft> readBinanceNft() {
        List<BinanceNft> nftList =null;
        try (FileReader reader = new FileReader("Data//Binance.json")) {
            // Khởi tạo Gson
            Gson gson = new GsonBuilder().create();

            // Đọc tệp JSON và chuyển đổi nó thành đối tượng NFTData
            JsonData nftData = gson.fromJson(reader, JsonData.class);

            // Truy cập các thuộc tính của đối tượng NFTData
            System.out.println("Code: " + nftData.getCode());
            System.out.println("Total: " + nftData.getData().getTotal());

            // Truy cập danh sách các NFT
            nftList = nftData.getData().getRows();
//            for (BinanceNft nft : nftList) {
//                System.out.println("Title: " + nft.getTitle());
//                System.out.println("Collection ID: " + nft.getCollectionId());
//                System.out.println("Cover URL: " + nft.getCoverUrl());
//                System.out.println("Network: " + nft.getNetwork());
//                System.out.println("Volume: " + nft.getVolume());
//                System.out.println("Volume Rate: " + nft.getVolumeRate());
//                System.out.println("Owners Count: " + nft.getOwnersCount());
//                System.out.println("Items Count: " + nft.getItemsCount());
//                System.out.println("Listed Count: " + nft.getListedCount());
//                System.out.println("Floor Price: " + nft.getFloorPrice());
//                System.out.println("Floor Price Rate: " + nft.getFloorPriceRate());
//                System.out.println("Verified: " + nft.getVerified());
//                System.out.println("----------------------");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return  nftList;
    }
}

