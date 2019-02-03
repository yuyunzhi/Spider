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
        for (Viewable viewableItem : viewableList) {
            System.out.println("-----------------------------------------------");
            viewableItem.display();
        }
    }
}
