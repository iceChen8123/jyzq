package com.ice.jyzq.service.app;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ice.jyzq.controller.app.HeaderInfo;
import com.ice.jyzq.controller.app.TokenUtil;
import com.ice.server.bean.app.AppUser;
import com.ice.server.bean.app.AppUserToken;
import com.ice.server.dao.app.AppUserDao;
import com.ice.server.dao.app.AppUserTokenDao;

@Service
public class AppUserService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AppUserTokenDao appUserTokenDao;

	@Autowired
	private AppUserDao appUserDao;

	@Autowired
	private TokenService tokenService;

	public String createUser(String userName, HeaderInfo headerInfo) {
		AppUser user = new AppUser();
		user.setCreateTime(new Date());
		user.setUserName(userName);
		appUserDao.save(user);

		AppUserToken token = new AppUserToken();
		token.setCreateTime(new Date());
		token.setImei(headerInfo.getImei());
		token.setModel(headerInfo.getModel());
		String appUserToken = TokenUtil.genToken(headerInfo);
		token.setToken(appUserToken);
		token.setUserName(userName);
		token.setUuid(headerInfo.getUuid());
		token.setVendor(headerInfo.getVendor());
		appUserTokenDao.save(token);

		TokenCache.getInstance().cacheAppUserToken(token);

		return appUserToken;
	}

	public void recordLogin(String token) {
		try {
			String userName = tokenService.getUserNameFromToken(token);
			appUserDao.updateLastLogin(userName);
		} catch (Exception e) {
			logger.error("recordLogin: ", e);
		}
	}

}
