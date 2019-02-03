package com.spider.java.model;

import java.io.*;
import java.util.ArrayList;

/**
 * 从路径中读取文件内容
 * 并返回一个数组集合，每个item是文件的内容
 */
public class NewsFactory {

    private File newsDir;

    public NewsFactory(String dir) throws Exception {
        newsDir = new File(dir); //打开目录

        //检查目录是否存在
        if(!newsDir.exists()){
            throw new Exception("路径不存在！");
        }
        //检查是否是目录
        if(!newsDir.isDirectory()){
            throw new Exception("请输入合法的目录");
        }
    }
        public ArrayList<News> fetch() {
            ArrayList<News> newsList = new ArrayList<News>();
            File[] files = newsDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String title = reader.readLine();//读取标题
                        reader.readLine(); //空行
                        String content = reader.readLine();//读取内容
                        News news = new News(title, content);
                        //读取相关新闻
                        for(int i =0 ; i<3;i++){
                            reader.readLine();//空行
                            String date =  reader.readLine(); //日期
                            String related_title =  reader.readLine(); //相关新闻标题
                            news.addRelated(date,related_title);
                        }
                        newsList.add(news);
                    } catch (IOException e) {
                        System.out.println("新闻读取出错！");
                    }
                }
            }
            return newsList;
        }



}
