package com.bean;

import java.util.Date;

public class Log {
    private Integer logid;

    private String tablename;

    private String operation;

    private String information;

    private Date operatingtime;

    private Integer operatorid;
    
    private Integer beoperatedid;
    
    private String operatorname;

    public Integer getBeoperatedid() {
		return beoperatedid;
	}

	public void setBeoperatedid(Integer beoperatedid) {
		this.beoperatedid = beoperatedid;
	}

	public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information == null ? null : information.trim();
    }

    public Date getOperatingtime() {
        return operatingtime;
    }

    public void setOperatingtime(Date operatingtime) {
        this.operatingtime = operatingtime;
    }

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }

	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
}