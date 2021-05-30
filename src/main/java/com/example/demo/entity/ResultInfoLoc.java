package com.example.demo.entity;

import com.example.demo.entity.dto.InventoryInfo;

import java.util.List;

public class ResultInfoLoc {
    private String sectorName;
    private String date;
    private List<InventoryInfo> infoCur;

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<InventoryInfo> getInfoCur() {
        return infoCur;
    }

    public void setInfoCur(List<InventoryInfo> infoCur) {
        this.infoCur = infoCur;
    }

    @Override
    public String toString() {
        return "ResultInfoLoc{" +
                "sectorName='" + sectorName + '\'' +
                ", date='" + date + '\'' +
                ", infoCur=" + infoCur +
                '}';
    }
}
