package com.spider.java.view;

import com.spider.java.model.Viewable;

import java.util.ArrayList;

/**
 * 从newsList获取文本信息
 * 在终端显示
 */
public class ListViewer {
    private ArrayList<Viewable> viewableList;

    public ListViewer(ArrayList<Viewable> viewableList) {
        this.viewableList = viewableList;
    }

    public void display() {
        //viewableList 里包含了 News 和 NewsWithRelated
        //如果要分别调用它们的display函数,就可以如下遍历
        for (Viewable viewableItem : viewableList) {
            System.out.println("-----------------------------------------------");
            viewableItem.display();
        }
    }
}
