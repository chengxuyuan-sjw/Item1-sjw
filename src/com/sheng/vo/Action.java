package com.sheng.vo;

import java.io.Serializable;

public class Action implements Serializable {
    private String actid;
    private String title;

    public String getActid() {
        return actid;
    }

    public void setActid(String actid) {
        this.actid = actid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
