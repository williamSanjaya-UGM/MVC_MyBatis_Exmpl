package com.example.demo.entity.dto;

public class InventoryInfo {
    private int id;
    private String name;
    private String sectorName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    @Override
    public String toString() {
        return "InventoryInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sectorName='" + sectorName + '\'' +
                '}';
    }
}
