package com.bean;

import java.math.BigDecimal;

public class Orderdetail extends OrderdetailKey {
    private Integer qty;

    private double price;

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}