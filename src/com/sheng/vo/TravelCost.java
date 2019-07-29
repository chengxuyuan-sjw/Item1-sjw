package com.sheng.vo;

public class TravelCost {
    private Long tcid;
    private Long tpid;
    private Long tid;
    private String title;
    private Double price;

    @Override
    public String toString() {
        return "TravelCost{" +
                "tcid=" + tcid +
                ", tpid=" + tpid +
                ", tid=" + tid +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getTcid() {
        return tcid;
    }

    public void setTcid(Long tcid) {
        this.tcid = tcid;
    }

    public Long getTpid() {
        return tpid;
    }

    public void setTpid(Long tpid) {
        this.tpid = tpid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
