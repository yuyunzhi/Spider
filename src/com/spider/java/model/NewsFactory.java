package com.spider.java.model;

import java.io.*;
import java.util.ArrayList;

/**
 * 从路径中读取文件内容
 * 并返回一个数组集合，每个item是文件的内容
 */

public class NewsFactory {
    protected File newsDir;

    public NewsFactory(String dir) throws Exception {
        newsDir = new File(dir); // 打开目录
        if (!newsDir.exists()) {
            throw new Exception("路径不存在!");
        }
        if (!newsDir.isDirectory()) {
            throw new Exception("输入路径不是一个合法目录！");
        }
    }

    //调用fetch,获取该文件夹下所需要的文件里的内容，并报保存到ArrayList
    public ArrayList<News> fetch() {
        ArrayList<News> newsList = new ArrayList<News>();

        File[] files = newsDir.listFiles();
        if (files != null) {
            for (File file : files) {
                //支持.txt .json格式
                NewsReader newsReader = null;
                if (file.getName().endsWith(".txt")) {
                    newsReader = new TextNewsReader(file);
                } else if (file.getName().endsWith(".json")) {
                    newsReader = new JsonNewsReader(file);
                }

                News news = newsReader.readNews();
                newsList.add(news);
            }
        }

        //继承于News，多了一个日期和相关内容
        NewsWithRelated newsWithRelated = new NewsWithRelated("", "Java、Java", "嗯，是java");
        newsWithRelated.addRelated("4.11", "Java1！");
        newsWithRelated.addRelated("4.17", "Java2！");
        //add的是News的 子类
        newsList.add(newsWithRelated);

        return newsList;
    }
}