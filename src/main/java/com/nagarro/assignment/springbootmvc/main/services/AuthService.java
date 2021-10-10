package com.nagarro.assignment.springbootmvc.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.assignment.springbootmvc.main.dao.AuthRepository;
import com.nagarro.assignment.springbootmvc.main.model.UserModel;

@Component
public class AuthService {

	@Autowired
	private AuthRepository loginrepo;

	public boolean getUser(String name , String password){
		List<UserModel> user = (List<UserModel>) this.loginrepo.findByUsernameAndPassword(name , password);
		
		if(user.size() > 0) {
			return true;
		}else {
			return false;
		}
	}
}
