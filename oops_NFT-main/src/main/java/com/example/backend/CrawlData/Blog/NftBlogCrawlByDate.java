package com.example.backend.CrawlData.Blog;

import com.example.backend.Model.Blog.Article;
import com.example.backend.Model.Blog.JsonWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;


public class NftBlogCrawlByDate {
    public static void crawlAndSave(String year, String month) {
        String url = "https://www.nftically.com/blog/" + year + "/" + month + "/";
        Document doc;

        try {
            doc = Jsoup
                    .connect(url)
                    .userAgent("Jsoup client")
                    .timeout(10000)
                    .get();

            List<Article> articlesList = WebPageScraper.scrapeArticles(doc);

            // Tạo đường dẫn thư mục lưu file
            String fileName = "Data//articles.json";

            // Ghi kết quả vào file
            JsonWriter.writeToJson(articlesList, fileName);

            // In ra danh sách bài viết, comment lại
            for (Article article : articlesList) {
                System.out.println("Title: " + article.getTitle());
                System.out.println("Link: " + article.getLink());
                System.out.println("Tag : " + article.getTag());
                System.out.println("Datetime : " + article.getDate());
                System.out.println("---------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
