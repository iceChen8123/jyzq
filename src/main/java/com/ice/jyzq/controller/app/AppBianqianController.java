package com.ice.jyzq.controller.app;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ice.jyzq.constant.FailResponse;
import com.ice.jyzq.service.BqService;
import com.ice.jyzq.util.JsonMapper;

@Controller
@RequestMapping(value = "app/bq")
public class AppBianqianController extends AppBaseController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BqService bqService;

	@RequestMapping(value = "get", method = RequestMethod.POST)
	@ResponseBody
	public String getSome(HttpServletRequest request, String token, @RequestParam(required = false) String bqStatus,
			int pageNo) {
		if (isRightToken(request, token)) {
			return JsonMapper.toJsonString(Response.failResponse(FailResponse.WrongToken));
		}
		return JsonMapper.toJsonString(Response.successResponse(bqService.getSome(
				tokenService.getUserNameFromToken(token), bqStatus, pageNo)));
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public String addBq(HttpServletRequest request, String token, @RequestParam(required = false) String title,
			String content) {
		logger.info("addBq : {} ", content);
		if (isRightToken(request, token)) {
			return JsonMapper.toJsonString(Response.failResponse(FailResponse.WrongToken));
		}
		bqService.addBq(tokenService.getUserNameFromToken(token), title, content);
		return JsonMapper.toJsonString("ok");
	}

	@RequestMapping(value = "done", method = RequestMethod.POST)
	@ResponseBody
	public String closeBq(HttpServletRequest request, String token, Long bqId) {
		if (isRightToken(request, token)) {
			return JsonMapper.toJsonString(Response.failResponse(FailResponse.WrongToken));
		}
		bqService.closeBq(tokenService.getUserNameFromToken(token), bqId);
		return JsonMapper.toJsonString("ok");
	}

	@RequestMapping(value = "reopen", method = RequestMethod.POST)
	@ResponseBody
	public String reopenBq(HttpServletRequest request, String token, Long bqId) {
		if (isRightToken(request, token)) {
			return JsonMapper.toJsonString(Response.failResponse(FailResponse.WrongToken));
		}
		bqService.reopenBq(tokenService.getUserNameFromToken(token), bqId);
		return JsonMapper.toJsonString("ok");
	}

	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public String find(HttpServletRequest request, String token, String content) {
		if (isRightToken(request, token)) {
			return JsonMapper.toJsonString(Response.failResponse(FailResponse.WrongToken));
		}
		return JsonMapper.toJsonString(bqService.find(tokenService.getUserNameFromToken(token), content));
	}

}
