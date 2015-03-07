package com.tms.dao;

import com.tms.entity.MstUser;

public interface UserDao {

	public MstUser authUser(String userName);
	
}
