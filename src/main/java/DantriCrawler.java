package main.java;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.List;
import java.util.regex.Pattern;


public class DantriCrawler extends WebCrawler {
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp4|zip|gz))$");

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches() && href.contains(PageConst.DAN_TRI_DOMAIN);
    }

    @Override
    public void visit(Page page) {
        List<Article> articles = ArticleUtils.getArticleList(page);
        System.out.println("page:" + page.getWebURL());
        System.out.println("article count: "  + articles.size());
        System.out.println("day la code" + articles.getClass());
    }

}



