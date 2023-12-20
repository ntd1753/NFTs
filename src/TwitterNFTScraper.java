import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.List;

public class TwitterNFTScraper {

    public static void main(String[] args) throws InterruptedException {
        // Khai báo đường dẫn đến ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/AD/Downloads/chromedriver.exe");

        // Mở trình duyệt Chrome
        WebDriver driver = new ChromeDriver();

        // Mở trang tìm kiếm Twitter với hashtag #NFT
        driver.get("https://twitter.com/search?q=%23NFT");

        // Đợi một chút để trang tìm kiếm tải hoàn tất
        Thread.sleep(2000);

        // Lấy tất cả các tweet từ trang tìm kiếm
        List<WebElement> tweets = driver.findElements(By.cssSelector("div[data-testid='tweet']"));

        // In các tweet
        for (WebElement tweet : tweets) {
            System.out.println(tweet.getText());
        }

        // Đóng trình duyệt
        driver.quit();
    }
}
