package com.spider.java;

import com.spider.java.model.*;
import com.spider.java.view.ListViewer;

import java.util.*;

/**
 * 抓取这个网站的新闻
 * https://readhub.cn
 */
public class Main {

    //本地存储新闻内容，如何在终端显示


    //1、抽象出对象
    //2、设计 对象应该具有的属性，状态和行为
    //3、思考 对象之间交互
    //4、开始编码
    public static void main(String[] args) throws Exception {

/*        //获取所储存的文件路径
        String resource_path= Main.class.getClassLoader().getResource("read_hub").getPath();

        *//**
         * 创建类 NewsFactory
         * 通过传入文件路径
         * 找到文件，及读取所需要的文件内容
         * 返回ArrayList
         *//*
        NewsFactory newsReader = new NewsFactory(resource_path);
        ArrayList<News> newsList = newsReader.fetch();

        //类型转换
        ArrayList<Viewable> viewableList =new ArrayList<Viewable>();
        viewableList.addAll(newsList);

        *//*
         * 创建类NewsListViewer
         * 拿到文件内容
         * 进行输出到终端
         *//*
        ListViewer viewer = new ListViewer(viewableList);
        viewer.display();*/


        //广度优先搜索方法
        Queue<NewsWithRelated> newsQueue = new LinkedList<>();
        String startUrl = "https://readhub.cn/topic/7K0i3s1eP84";
        NewsWithRelated startNews = UrlNewsReader.read(startUrl);//静态方法，直接使用类名调用。
        newsQueue.add(startNews);


        ArrayList<String> allUrl = new ArrayList<>();
        allUrl.add(startUrl);

        while(!newsQueue.isEmpty()){

            NewsWithRelated currentNews = newsQueue.poll();
           //currentNews.display();
            for(Map.Entry<String,String> entry : currentNews.getRelated().entrySet()){
                String url = entry.getValue();
                Boolean hasUrl = allUrl.contains(url);
                System.out.println("--------------------");
                System.out.println("所有的url");
                System.out.println(allUrl);
                System.out.println("当前的url");
                System.out.println(url);
                System.out.println("是否包含");
                System.out.println(hasUrl);
                if(hasUrl){
                    continue;
                }else{
                    allUrl.add(url);
                    NewsWithRelated next = UrlNewsReader.read(url);
                    newsQueue.add(next);
                }
                //这里判断url，是否是重复的，如果重复，就跳过


            }
        }

        System.out.println(allUrl.size());


        //广度优先实现去重
        //保存到本地以Json的格式




    }
}
