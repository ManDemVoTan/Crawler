package main.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(PageConst.DAN_TRI_FULL_URL).get();
            List<Article> articles = ArticleUtils.getArticleList(doc);
            System.out.println("page:" + doc.title());
            System.out.println("article count: " + articles.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
