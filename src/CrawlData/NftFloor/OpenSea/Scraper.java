package CrawlData.NftFloor.OpenSea;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

public interface Scraper {
    Map<String, JSONObject> scrape() throws IOException;
}