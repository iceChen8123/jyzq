package com.ice.jyzq.service.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ice.server.bean.app.AppUserToken;
import com.ice.server.dao.app.AppUserTokenDao;

@Service
public class TokenService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AppUserTokenDao appUserTokenDao;

	public String getUserNameFromToken(String token) {
		AppUserToken appUserToken = TokenCache.getInstance().getAppUserToken(token);
		if (appUserToken != null) {
			logger.info("getUserNameFromToken fromCache.");
			return appUserToken.getUserName();
		}

		List<AppUserToken> appUserTokens = appUserTokenDao.findByToken(token);
		logger.info("getUserNameFromToken fromDb. token: " + token);
		if (appUserTokens.size() != 1) {
			return "";
		} else {
			TokenCache.getInstance().cacheAppUserToken(appUserTokens.get(0));
			return appUserTokens.get(0).getUserName();
		}
	}
}
