package com.sheng.vo;

import java.io.Serializable;

public class Type implements Serializable {
    private int tpid;
    private String title;

    @Override
    public String toString() {
        return "Type{" +
                "tpid=" + tpid +
                ", title='" + title + '\'' +
                '}';
    }

    public int getTpid() {
        return tpid;
    }

    public void setTpid(int tpid) {
        this.tpid = tpid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
