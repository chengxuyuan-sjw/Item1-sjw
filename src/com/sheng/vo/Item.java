package com.sheng.vo;

import java.io.Serializable;

public class Item implements Serializable {
    private String iid;
    private String  title;

    @Override
    public String toString() {
        return "Item{" +
                "iid='" + iid + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
