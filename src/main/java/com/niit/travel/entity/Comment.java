package com.niit.travel.entity;

import java.util.Date;

public class Comment {
    private Integer COId;
    private Integer COUser_id;
    private Integer COTN_id;
    private Date CODate;
    private String COStatus;
    private String CODetails;

    public Integer getCOTN_id() {
        return COTN_id;
    }

    public void setCOTN_id(Integer COTN_id) {
        this.COTN_id = COTN_id;
    }

    public Integer getCOId() {
        return COId;
    }

    public void setCOId(Integer COId) {
        this.COId = COId;
    }

    public Integer getCOUser_id() {
        return COUser_id;
    }

    public void setCOUser_id(Integer COUser_id) {
        this.COUser_id = COUser_id;
    }

    public Date getCODate() {
        return CODate;
    }

    public void setCODate(Date CODate) {
        this.CODate = CODate;
    }

    public String getCOStatus() {
        return COStatus;
    }

    public void setCOStatus(String COStatus) {
        this.COStatus = COStatus;
    }

    public String getCODetails() {
        return CODetails;
    }

    public void setCODetails(String CODetails) {
        this.CODetails = CODetails;
    }
}
