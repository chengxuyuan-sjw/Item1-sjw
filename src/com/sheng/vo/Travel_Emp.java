package com.sheng.vo;

public class Travel_Emp {
    private Long tid;
    private String eid;

    @Override
    public String toString() {
        return "Travel_Emp{" +
                "tid=" + tid +
                ", eid='" + eid + '\'' +
                '}';
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }
}
