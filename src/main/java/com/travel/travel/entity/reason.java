package com.travel.travel.entity;

import java.util.Date;
import java.util.SplittableRandom;

public class reason {
    private Integer RId;
    private Integer RUser_id;
    private String RCN_Title;
    private Integer RCN_id;
    private String RDetails;
    private Date RDate;

    public Integer getRId() {
        return RId;
    }

    public void setRId(Integer RId) {
        this.RId = RId;
    }

    public Integer getRUser_id() {
        return RUser_id;
    }

    public void setRUser_id(Integer RUser_id) {
        this.RUser_id = RUser_id;
    }

    public String getRCN_Title() {
        return RCN_Title;
    }

    public void setRCN_Title(String RCN_Title) {
        this.RCN_Title = RCN_Title;
    }

    public Integer getRCN_id() {
        return RCN_id;
    }

    public void setRCN_id(Integer RCN_id) {
        this.RCN_id = RCN_id;
    }

    public String getRDetails() {
        return RDetails;
    }

    public void setRDetails(String RDetails) {
        this.RDetails = RDetails;
    }

    public Date getRDate() {
        return RDate;
    }

    public void setRDate(Date RDate) {
        this.RDate = RDate;
    }
}
