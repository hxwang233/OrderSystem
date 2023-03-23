package com.service.impl;
import com.bean.User;
import com.dao.UserMapper;
import com.service.dao.CommentLoginDao;
import com.utils.SqlUtil;

public class CommentLoginImpl implements CommentLoginDao{

	@Override
	public User loginJudge(int userid, String password) {

		UserMapper adminMapper=new SqlUtil().getUserMapper();
	
		return 	adminMapper.selectUP(userid, password, 1);
	}

}
