package com.service.dao;

import com.bean.User;

public interface CommentLoginDao {
	User loginJudge(int userid,String password);

}
