package com.ice.jyzq.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ice.jyzq.util.EndecryptUtils;
import com.ice.server.bean.User;
import com.ice.server.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User save(User userin) {
		String userName = userin.getUserName();
		String password = userin.getPassword();
		User user = EndecryptUtils.md5Password(userName, password);
		if (userin.getDsId() != 0) {
			user.setDsId(userin.getDsId());
		}
		user.setCreateTime(new Date());
		return userDao.save(user);
	}

	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	public void updateUserLoginInfo(Long id) {
		userDao.updateUserLoginInfo(id);
	}

	public boolean ifUserExists(String userName) {
		User user = userDao.findByUserName(userName);
		return (user != null) && (userName.equals(user.getUserName()));
	}

	public User findByDsId(String dsId) {
		return userDao.findByDsId(Long.parseLong(dsId));
	}

}
