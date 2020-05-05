package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.UserDao;
import com.google.firebase.auth.FirebaseAuthException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	UserDao userDao;

	@PostMapping("/signup")
	public ResponseBean<UserBean> signup(@RequestBody UserBean userBean) {
		try {
			userDao.insertUser(userBean);
		} catch (FirebaseAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseBean<UserBean> response = new ResponseBean<UserBean>();
		response.setData(userBean);
		response.setMessage("Success");
		response.setStatusCode(200);
		return response;
	}

}
