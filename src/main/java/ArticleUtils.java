package main.java;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class ArticleUtils {
    static List<Article> getArticleList(Document doc) {
        List<Article> articles = new ArrayList<Article>();
        Elements hrefs = doc.getElementsByTag("a");
        for (Element aTag : hrefs) {
            if (aTag.text().contains(">>")) {
                Article article = new Article();
                article.setTitle(aTag.attr("title"));
                article.setDetailUrl(aTag.attr("href"));

                Elements imgTags = aTag.getElementsByTag("img");
                for (Element imgTag : imgTags) {
                    article.setMainImageUrl(imgTag.attr("src"));
                }

                articles.add(article);
            }
        }
        return articles;
    }

    static Article parse(Document doc, Article article) {
        Element divContent = doc.getElementById("divNewsContent");
        article.setContent(divContent.text());


        return article;
    }

}
