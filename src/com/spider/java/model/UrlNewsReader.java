package com.spider.java.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

//从链接中读取News
public class UrlNewsReader {

    public static NewsWithRelated read(String url) throws IOException {
        //Jsoup 读取和解析 页面
        Document doc = Jsoup.connect(url).get();
        Elements titleElements = doc.select("title");
        String title = titleElements.first().text();
        String content = doc.select("meta[property=og:description]").attr("content");

        // select 语法
        // 1. 标签名 "title", "meta", "meta"
        // 2. class ".main___dXbgk"
        // 3. id "#root"
        // 4. 属性 "[name=xxx]"

        /*
        Elements contentElements = doc.select(".summary___1i4y3");
        String content = contentElements.first().text();
        */
        Elements body = doc.select("body");
        Elements div = body.select(".row___3h219");

        NewsWithRelated news = new NewsWithRelated(title, content);

        Elements relatedElements = doc.select(".row___3h219");
        for (Element element : relatedElements) {
            Elements children  = element.children();
            String relatedTitle = children.get(0).text();
            String relatedUrl = children.get(0).absUrl("href");
            String date = children.get(1).text();
            news.addRelated(relatedTitle, relatedUrl);
        }

        return news;
    }
}
