package com.oracle.hrb.dao;

import java.util.List;

import com.oracle.hrb.bean.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(int id);
	User findById(int id);
	User findByUsername(String username);
	List<User> findAll();
	
	void updateUsernameById(int id, String username);
}
