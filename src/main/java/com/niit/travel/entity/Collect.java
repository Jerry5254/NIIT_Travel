package com.niit.travel.entity;

import java.util.Date;

public class Collect {
    private Integer Collect_Id;
    private Integer Collect_Noteid;
    private Integer Collect_Userid;
    private Date Collect_Date;

    public Integer getCollect_Id() {
        return Collect_Id;
    }

    public void setCollect_Id(Integer collect_Id) {
        Collect_Id = collect_Id;
    }

    public Integer getCollect_Noteid() {
        return Collect_Noteid;
    }

    public void setCollect_Noteid(Integer collect_Noteid) {
        Collect_Noteid = collect_Noteid;
    }

    public Integer getCollect_Userid() {
        return Collect_Userid;
    }

    public void setCollect_Userid(Integer collect_Userid) {
        Collect_Userid = collect_Userid;
    }

    public Date getCollect_Date() {
        return Collect_Date;
    }

    public void setCollect_Date(Date collect_Date) {
        Collect_Date = collect_Date;
    }
}
