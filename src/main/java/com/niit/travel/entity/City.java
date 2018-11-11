package com.niit.travel.entity;

public class City {
    private Integer CId;
    private String CName;
    private String CStatus;
    private String CDes;
    private Integer CHit_Number;

    public Integer getCId() {
        return CId;
    }

    public void setCId(Integer CId) {
        this.CId = CId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCStatus() {
        return CStatus;
    }

    public void setCStatus(String CStatus) {
        this.CStatus = CStatus;
    }

    public String getCDes() {
        return CDes;
    }

    public void setCDes(String CDes) {
        this.CDes = CDes;
    }

    public Integer getCHit_Number() {
        return CHit_Number;
    }

    public void setCHit_Number(Integer CHit_Number) {
        this.CHit_Number = CHit_Number;
    }
}
