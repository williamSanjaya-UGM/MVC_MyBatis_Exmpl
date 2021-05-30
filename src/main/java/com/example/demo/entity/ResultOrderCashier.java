package com.example.demo.entity;

import com.example.demo.entity.dto.DetHandleOrder;

import java.io.Serializable;
import java.util.List;

public class ResultOrderCashier implements Serializable {
    private int transId;
    private List<DetHandleOrder> listOrderBy;

    public int getTransId() {
        return transId;
    }

    public void setTransId(int tranId) {
        this.transId = tranId;
    }

    public List<DetHandleOrder> getListOrderBy() {
        return listOrderBy;
    }

    public void setListOrderBy(List<DetHandleOrder> listOrderBy) {
        this.listOrderBy = listOrderBy;
    }

    @Override
    public String toString() {
        return "ResultOrderCashier{" +
                "transId=" + transId +
                ", listOrderBy=" + listOrderBy +
                '}';
    }
}
