package com.nagarro.assignment.springbootmvc.main.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.assignment.springbootmvc.main.model.UserModel;



public interface AuthRepository extends CrudRepository<UserModel, Integer>{

	public List<UserModel> findByUsernameAndPassword(String name , String password);

}
