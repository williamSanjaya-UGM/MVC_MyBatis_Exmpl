package com.example.demo.entity.dto;

import java.io.Serializable;

public class DetHandleOrder implements Serializable {
    private String cashierName;
    private String foodName;
    private double price;

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DetHandleOrder{" +
                "cashierName='" + cashierName + '\'' +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                '}';
    }
}
