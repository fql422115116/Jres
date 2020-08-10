package com.oracle.hrb.controller;

import com.oracle.hrb.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.hrb.bean.User;
import com.oracle.hrb.service.UserService;
import sun.security.util.Password;

import javax.sound.midi.Soundbank;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	@RequestMapping("/list.do")
	public Object userList(){
		return service.userList();
	}
	@RequestMapping("/delete.do")
	public void deleteUser(int id){
		System.out.println(id);
		 service.deleteUser(id);
	}
	@RequestMapping("/add.do")
	public Object addUser(User user){
		System.out.println(user);
		return service.addUser(user);
	}
	@RequestMapping("/getUserById.do")
	public Object getUserById(int id){
		System.out.println(id);
		return service.findUserById(id);
	}
	@RequestMapping("/updateUser.do")
	public Result updateUser(User user){
		Result result = new Result();
		System.out.print(result);
		if(user.getUsername() ==null ||user.getUsername().length()==0){
			result.setOk(false);
			System.out.print(result);
			result.addValue("usernameError","用户名不能为空");
		}
		if(user.getPassword()==null || user.getPassword().length()==0){
			result.addValue("passwordError","密码不能为空");
		}
		if(result.isOk()){
			service.updateUser(user);
		}
		return result;

	}
}
