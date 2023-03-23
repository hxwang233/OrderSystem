package com.service.impl;

import java.util.List;
import com.bean.Product;
import com.dao.ProductMapper;
import com.google.gson.Gson;
import com.utils.SqlUtil;
import com.utils.TableData;
import com.service.dao.ProductManagerDao;

public class ProductManagerImpl implements ProductManagerDao {
	public String initProduct(int page, int limit, String condition) {
		SqlUtil u = new SqlUtil();
		ProductMapper productMapper = u.getProductMapper();
		int cnt = productMapper.selectCount(u.count() + " product ");
		List<Product> products = productMapper
				.selectSql(u.all() + " product where state = 1 " + condition + u.limit(page, limit));
		Gson gson = new Gson();
		TableData obj = new TableData();

		obj.setCount(cnt);
		obj.setData(products);
		return gson.toJson(obj);
	}

	public String judgeproduct(String condition) {
		SqlUtil u = new SqlUtil();
		ProductMapper productMapper = u.getProductMapper();
		Integer productno = productMapper.selectpno(condition);
		if (productno != null) {
			Gson gson = new Gson();
			return gson.toJson(productno);
		} else
			return null;

	}

}
