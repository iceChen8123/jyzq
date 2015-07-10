package com.ice.jyzq.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ice.jyzq.common.UserUtil;
import com.ice.jyzq.util.JsonMapper;

@Controller
public class HomeController {

	private static Map<String, Long> onlineMap = new HashMap<String, Long>(1000);

	@Autowired
	private UserUtil userUtil;

	@RequestMapping(value = { "/hello", "", "/b/hello" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = { "/ip" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
		return JsonMapper.toJsonString(ip);
	}

	@RequestMapping(value = "/getonlinenumber", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getonlinenumber(Model model) {
		if (StringUtils.isNotBlank(userUtil.getCurrentUserName())) {
			onlineMap.put(userUtil.getCurrentUserName(), System.currentTimeMillis());
		}
		Map<String, String> onlineinfo = new HashMap<String, String>();
		onlineinfo.put("onlinenumber", onlineMap.size() + "");
		return JsonMapper.toJsonString(onlineinfo);
	}

	@PostConstruct
	private void init() {
		Thread onlineTask = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
					}
					Iterator<Map.Entry<String, Long>> iterator = onlineMap.entrySet().iterator();
					while (iterator.hasNext()) {
						if (System.currentTimeMillis() - iterator.next().getValue() > 5000) {
							iterator.remove();
						}
					}
				}
			}
		});
		onlineTask.setDaemon(true);
		onlineTask.start();
	}
}
