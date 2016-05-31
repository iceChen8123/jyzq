//package com.ice.jyzq.controller;
//
//import java.util.List;
//
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.ice.jyzq.controller.app.Response;
//import com.ice.jyzq.service.AdviceService;
//import com.ice.jyzq.util.JsonMapper;
//import com.ice.server.bean.sys.Advice;
//
//@Controller
//@RequestMapping("advise")
//public class AdviceController {
//
//	Logger logger = LoggerFactory.getLogger(getClass());
//
//	@Autowired
//	private AdviceService adviceService;
//
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	@ResponseBody
//	public String advise(String mail, String qq, String advice) {
//		if (StringUtils.isEmpty(advice)) {
//			logger.warn("无效advice: mail[" + mail + "],qq[" + qq + "]");
//		} else {
//			logger.info("advice: mail[" + mail + "],qq[" + qq + "],advice[" + advice + "]");
//			adviceService.saveNoLogin(mail, qq, advice);
//		}
//		return JsonMapper.toJsonString(Response.successResponse(""));
//	}
//
//	@RequestMapping(value = "get", method = { RequestMethod.POST, RequestMethod.GET })
//	@ResponseBody
//	public String getAdvices(@RequestParam(value = "pageNo", required = true) int pageNo) {
//		List<Advice> advices = adviceService.findLatestAdvices(pageNo, 10);
//		return JsonMapper.toJsonString(advices);
//	}
//}
