package com.ice.jyzq.service.app;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import com.ice.server.bean.app.AppUserToken;

public class TokenCache {

	private static TokenCache tokenCache = new TokenCache();;

	private static Map<String, AppUserTokenRef> appUsertokenRefs = new HashMap<String, AppUserTokenRef>();

	private static ReferenceQueue q = new ReferenceQueue();// 垃圾Reference的队列

	private TokenCache() {
	}

	private static class AppUserTokenRef extends SoftReference {
		private String _key = "";

		public AppUserTokenRef(AppUserToken appUserToken, ReferenceQueue q) {
			super(appUserToken, q);
			_key = appUserToken.getToken();
		}
	}

	public static void cacheAppUserToken(AppUserToken appUserToken) {
		cleanCache();// 清除垃圾引用
		AppUserTokenRef ref = new AppUserTokenRef(appUserToken, q);
		appUsertokenRefs.put(appUserToken.getToken(), ref);
	}

	public static AppUserToken getAppUserToken(String token) {
		AppUserToken em = null;
		// 缓存中是否有该Employee实例的软引用，如果有，从软引用中取得。
		if (appUsertokenRefs.containsKey(token)) {
			AppUserTokenRef ref = (AppUserTokenRef) appUsertokenRefs.get(token);
			em = (AppUserToken) ref.get();
		}
		return em;
	}

	private static void cleanCache() {
		AppUserTokenRef ref = null;
		while ((ref = (AppUserTokenRef) q.poll()) != null) {
			appUsertokenRefs.remove(ref._key);
		}
	}

}
