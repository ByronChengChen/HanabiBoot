package com.HanabiBoot.service;

import java.sql.SQLException;

import com.HanabiBoot.dao.UserDao;
import com.HanabiBoot.domain.User;

public class UserService {

	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return new UserDao().getUserByUsernameAndPwd(username,password);
	}

}
