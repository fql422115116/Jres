package com.oracle.hrb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.hrb.bean.User;
import com.oracle.hrb.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	public List<User> userList(){
		return dao.findAll();
	}
	
	public void deleteUser(int id){
		dao.delete(id);
	}
	public User addUser(User user) {
		dao.add(user);
		return user;
	}
	public User findUserById(int id){
		return dao.findById(id);
	}
	public  void updateUser(User user){
		dao.update(user);
	}
}
