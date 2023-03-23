package com.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.bean.User;
import com.dao.UserMapper;
import com.service.dao.ManageLoginDao;
import com.utils.SqlUtil;

public class ManageLoginImpl implements ManageLoginDao{

	public User loginJudge(int userid, String password) {
		
		UserMapper adminMapper=new SqlUtil().getUserMapper();
	
		return 	adminMapper.selectUP(userid, password, 0);
	}

}
