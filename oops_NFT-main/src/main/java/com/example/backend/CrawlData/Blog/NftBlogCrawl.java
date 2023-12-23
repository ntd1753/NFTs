package com.example.backend.CrawlData.Blog;

import com.example.backend.Model.Blog.Article;
import com.example.backend.Model.Blog.JsonWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class NftBlogCrawl {

    public static void main(String[] args) {
        int numpage = 2;
        for (int page = 1; page <= numpage; page++) {
            String url = "https://www.nftically.com/blog/page/" + page + "/";
            Document doc;

            try {
                doc = Jsoup
                        .connect(url)
                        .userAgent("Jsoup client")
                        .timeout(10000)
                        .get();

                List<Article> articlesList = WebPageScraper.scrapeArticles(doc);

                String fileName = "Data//Blog.json";
                JsonWriter.writeToJson(articlesList, fileName);

                // In ra danh sách bài viết
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
}


