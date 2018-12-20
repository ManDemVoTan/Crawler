package main.java;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ArticleUtils {
    public static List<Article> getArticleList(Page page) {
        List<Article> articles = new ArrayList<Article>();
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();
            Document doc = Jsoup.parse(html);
            Elements hrefs = doc.select("a");


            for (Element aTag : hrefs) {
                if (aTag.text().contains(">>")) {
                    Article article = new Article();
                    article.setTitle(aTag.attr("title"));
                    article.setDetailUrl(aTag.attr("src"));
                    articles.add(article);
                }
            }
        }
        return articles;
    }
}
