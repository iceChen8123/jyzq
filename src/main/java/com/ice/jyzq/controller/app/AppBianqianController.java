package com.ice.jyzq.controller.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String getSome(String token, @RequestParam(required = false) String bqStatus, int pageNo) {
		return JsonMapper.toJsonString(bqService.getSome(getUserNameFromToken(token), bqStatus, pageNo));
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public String addBq(String token, @RequestParam(required = false) String title, String content) {
		bqService.addBq(getUserNameFromToken(token), title, content);
		return JsonMapper.toJsonString("ok");
	}

	@RequestMapping(value = "done", method = RequestMethod.POST)
	@ResponseBody
	public String closeBq(String token, Long bqId) {
		bqService.closeBq(getUserNameFromToken(token), bqId);
		return JsonMapper.toJsonString("ok");
	}

	@RequestMapping(value = "reopen", method = RequestMethod.POST)
	@ResponseBody
	public String reopenBq(String token, Long bqId) {
		bqService.reopenBq(getUserNameFromToken(token), bqId);
		return JsonMapper.toJsonString("ok");
	}

	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public String find(String token, String content) {
		return JsonMapper.toJsonString(bqService.find(getUserNameFromToken(token), content));
	}

}
