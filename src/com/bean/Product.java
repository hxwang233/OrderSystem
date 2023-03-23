package com.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer productno;

    private String productname;

    private String productclass;

    private double productprice;

    private Date createdate;
    
    private Integer state;

    public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

    public Integer getProductno() {
        return productno;
    }

    public void setProductno(Integer productno) {
        this.productno = productno;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getProductclass() {
        return productclass;
    }

    public void setProductclass(String productclass) {
        this.productclass = productclass == null ? null : productclass.trim();
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}