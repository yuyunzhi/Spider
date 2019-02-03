package com.spider.java;

import com.spider.java.model.News;
import com.spider.java.model.NewsFactory;
import com.spider.java.model.Viewable;
import com.spider.java.view.ListViewer;

import java.util.ArrayList;

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

        //获取所储存的文件路径
        String resource_path= Main.class.getClassLoader().getResource("read_hub").getPath();

        /**
         * 创建类 NewsFactory
         * 通过传入文件路径
         * 找到文件，及读取所需要的文件内容
         * 返回ArrayList
         */
        NewsFactory newsReader = new NewsFactory(resource_path);
        ArrayList<News> newsList = newsReader.fetch();

        //类型转换
        ArrayList<Viewable> viewableList =new ArrayList<Viewable>();
        viewableList.addAll(newsList);

        /*
         * 创建类NewsListViewer
         * 拿到文件内容
         * 进行输出到终端
         */
        ListViewer viewer = new ListViewer(viewableList);
        viewer.display();


    }
}
