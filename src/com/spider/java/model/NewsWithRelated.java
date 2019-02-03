package com.spider.java.model;

import java.util.HashMap;
import java.util.Map;

public class NewsWithRelated extends News{
    private HashMap<String,String> related;

    public NewsWithRelated(String url,String title, String content) {
        super(title, content);
        related=new HashMap<String,String>();
    }

    public void addRelated(String date,String related){
        this.related.put(date,related);
    }

    public HashMap<String, String> getRelated() {
        return this.related;
    }

    public void display(){
        super.display();
        System.out.println("|Related|");
        System.out.println("我被打印了，NewsWithRelated");

        for(Map.Entry<String,String> entry:this.related.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }


}
