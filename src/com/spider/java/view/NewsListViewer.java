package com.spider.java.view;

import com.spider.java.model.News;

import java.util.ArrayList;

/**
 *
 * 从newsList获取文本信息
 * 在终端显示
 */
public class NewsListViewer {
    private ArrayList<News> newsList;

    public NewsListViewer(ArrayList<News> newsList){
        this.newsList=newsList;
    }

    public void display(){
        for(News news : newsList){
            System.out.println("---------------------");
            System.out.println("|Tittle|"+news.getTitle());
            System.out.println("|Content|"+news.getContent());
            System.out.println("|Related|"+news.getRelated());

        }

    }

}
