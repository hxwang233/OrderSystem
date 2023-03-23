package com.service.dao;

import com.bean.User;

public interface ManageLoginDao {
	
	User loginJudge(int userid,String password);

	
}
