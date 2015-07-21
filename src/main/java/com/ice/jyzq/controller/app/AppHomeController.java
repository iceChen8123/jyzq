package com.ice.jyzq.controller.app;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ice.jyzq.util.JsonMapper;

@Controller
@RequestMapping(value = "app")
public class AppHomeController {

	Logger logger = LoggerFactory.getLogger(getClass());

	private static final SimpleDateFormat DATE_FORMAT_FOR_SHOWAPI = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final String SHOWAPI_APPID = "3901";
	private static final String SHOWAPI_KEY = "4da9164d87ae4908a19817e86458ffcc";

	@RequestMapping(value = { "/hello", "" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String home(Model model) {
		return JsonMapper.toJsonString("ok");
	}

	@RequestMapping(value = { "/ip" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		logger.info("getIp: {} ", ip);
		return JsonMapper.toJsonString(ip);
	}

	public static void main(String[] args) throws IOException {

		// String ip = "221.13.21.194";
		// String city = getCityByIp(ip);
		// System.out.println(city);
		//
		// String dateString = DATE_FORMAT_FOR_SHOWAPI.format(new Date());
		//
		// HttpClient httpClient = new DefaultHttpClient();
		// HttpGet request = new
		// HttpGet("http://route.showapi.com/9-2?showapi_appid=" + SHOWAPI_APPID
		// + "&showapi_timestamp=" + dateString + "&area=" + city +
		// "&showapi_sign=" + SHOWAPI_KEY);
		//
		// HttpResponse httpResponse = httpClient.execute(request);
		// BasicResponseHandler responseHandler = new BasicResponseHandler();
		// String response = responseHandler.handleResponse(httpResponse);
		//
		// JSONObject responseBody =
		// JSON.parseObject(response).getJSONObject("showapi_res_body");
		//
		// JSONObject todayWeather = responseBody.getJSONObject("f1");
		// JSONObject tomorrowWeather = responseBody.getJSONObject("f2");
		//
		// System.out.println(city);
		// System.out.println(todayWeather);
		// System.out.println(tomorrowWeather);

	}

	// private static String getCityByIp(String ip) throws IOException,
	// ClientProtocolException, HttpResponseException {
	// String dateString = DATE_FORMAT_FOR_SHOWAPI.format(new Date());
	//
	// HttpClient httpClient = new DefaultHttpClient();
	// HttpGet request = new
	// HttpGet("http://route.showapi.com/20-1?showapi_appid=" + SHOWAPI_APPID
	// + "&showapi_timestamp=" + dateString + "&ip=" + ip + "&showapi_sign=" +
	// SHOWAPI_KEY);
	//
	// HttpResponse httpResponse = httpClient.execute(request);
	// BasicResponseHandler responseHandler = new BasicResponseHandler();
	// String response = responseHandler.handleResponse(httpResponse);
	//
	// JSONObject responseJson = JSON.parseObject(response);
	// String city =
	// responseJson.getJSONObject("showapi_res_body").get("city").toString();
	// return city;
	// }
}
