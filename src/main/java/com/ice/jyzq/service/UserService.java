package com.ice.jyzq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ice.jyzq.util.EndecryptUtils;
import com.ice.server.bean.User;
import com.ice.server.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User save(String username, String password) {
		User user = EndecryptUtils.md5Password(username, password);
		return userDao.save(user);
	}

	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	public void updateUserLoginInfo(Long id) {
//		userDao.updateUserLoginInfo(id);
	}

	public boolean ifUserExists(String userName) {
		User user = userDao.findByUserName(userName);
		return (user != null) && (userName.equals(user.getUserName()));
	}

}
