package experiment;

import CrawlData.NftFloor.Binance.BinanceJsonReader;
import CrawlData.NftFloor.OpenSea.OpenSeaJsonReader;
import CrawlData.Twitter.TwitterJsonReader;
import Model.NftFloor.BinanceNft;
import Model.NftFloor.OpenSeaNft;
import Model.Twitter.Tweet;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    //TEST OPENSEA
        String filePath = "Data//OpenSea.json";
        OpenSeaJsonReader op = new OpenSeaJsonReader();
        // Gọi phương thức để đọc dữ liệu và nhận danh sách OpenSeaNft
        List<OpenSeaNft> openSeaNftList = op.readOpenSeaJson(filePath);
        for (OpenSeaNft nft: openSeaNftList
             ) {
            System.out.println(nft.getName());
            System.out.println(nft.getFloorPrice());
        }
    //TEST BINANCE
        BinanceJsonReader bn = new BinanceJsonReader();
        List<BinanceNft> binance = bn.readBinanceNft();
        for (BinanceNft nft : binance) {
               System.out.println("Title: " + nft.getTitle());
               System.out.println("Collection ID: " + nft.getCollectionId());
               }
    //Test TWITTER
        TwitterJsonReader tw =new TwitterJsonReader();
        List<Tweet> tweetList = tw.readTweetJson();
        for (Tweet tweet: tweetList) {
            System.out.println("Date: " + tweet.getDate());
            System.out.println("User: " + tweet.getUser());
            System.out.println("Content: " + tweet.getContent());
            System.out.println("Hashtags: " + tweet.getHashtags());
            System.out.println("----------------------");
        }
    }
}
