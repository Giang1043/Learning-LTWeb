package vn.lightforknight.dao;

import java.util.List;

import vn.lightforknight.models.UserModel;

public interface IUserDAO {

	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);

}
