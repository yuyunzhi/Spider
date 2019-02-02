package com.spider.java.model;

import java.io.File;

public class NewsFactory {

    private File newsDir;

    public NewsFactory(String dir) throws Exception {
        newsDir = new File(dir); //打开目录
        if(!newsDir.exists()){
            throw new Exception("路径不存在！");
        }
    }
}
