package com.service.impl;

import java.util.List;

import com.dao.EChartsMapper;
import com.google.gson.Gson;
import com.service.dao.EchartsDao;
import com.utils.EChartsData;
import com.utils.SqlUtil;

public class EchartsImpl implements EchartsDao{
	

	@Override
	public String getEcharts(String search) {
		EChartsMapper e;
		String res=null;
		Gson gson=new Gson();
		e=new SqlUtil().getEChartsMapper();
		if(search.equals("客户分布")) {
			List<EChartsData> ec=e.selectAddress();
			res=gson.toJson(ec);
		}
		if(search.equals("近一周订单分布")) {
			List<EChartsData> ec=e.selectWeekOrder();
			res=gson.toJson(ec);
		}
		if(search.equals("近一周订单交易额")) {
			List<EChartsData> ec=e.selectWeekSum();
			res=gson.toJson(ec);
		}
		return res;
	}

}
