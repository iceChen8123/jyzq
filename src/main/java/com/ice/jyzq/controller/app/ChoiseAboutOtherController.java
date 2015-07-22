package com.ice.jyzq.controller.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ice.jyzq.service.ChoiseService;
import com.ice.jyzq.util.JsonMapper;

@Controller
@RequestMapping(value = "choise/other")
public class ChoiseAboutOtherController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ChoiseService choiseService;

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam("token") String token, @RequestParam("choiseid") long choiseid) {
		return null;
	}

	@RequestMapping(value = "opened/get", method = RequestMethod.GET)
	@ResponseBody
	public String getOpenedChoise(@RequestParam("token") String token,
			@RequestParam(value = "pageNo", required = true) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) int pageSize) {
		return null;
	}

	@RequestMapping(value = "vote", method = RequestMethod.POST)
	@ResponseBody
	public String vote(@RequestParam("token") String token, @RequestParam("choiseid") long choiseid,
			@RequestParam("choiseitemid") long choiseitemid,
			@RequestParam(value = "comment", required = false) String comment) {
		return JsonMapper.toJsonString("谢谢,你正在拯救一个纠结中的生命^_^");
	}

}
