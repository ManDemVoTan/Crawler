package main.java;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ArticleUtils {
    public static List<Article> getArticleList(Document doc) {
        List<Article> articles = new ArrayList<Article>();
        Elements hrefs = doc.getElementsByTag("a");
        for (Element aTag : hrefs) {
            if (aTag.text().contains(">>")) {
                Article article = new Article();
                article.setTitle(aTag.attr("title"));
                article.setDetailUrl(aTag.attr("src"));
                articles.add(article);
            }
        }
        return articles;
    }
}
