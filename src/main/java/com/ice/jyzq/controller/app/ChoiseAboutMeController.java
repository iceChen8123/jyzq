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

@Controller
@RequestMapping(value = "choise/mine")
public class ChoiseAboutMeController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ChoiseService choiseService;

	@RequestMapping(value = "create", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String add(@RequestParam("token") String token, @RequestParam("choises") String choises,
			@RequestParam(value = "extention", required = false) String extention) {
		return null;
	}

	@RequestMapping(value = "opened/get", method = RequestMethod.GET)
	@ResponseBody
	public String getMyOpenedChoise(@RequestParam("token") String token,
			@RequestParam(value = "pageNo", required = true) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) int pageSize) {
		return null;
	}

	@RequestMapping(value = "choose", method = RequestMethod.GET)
	@ResponseBody
	public String chooseChoise(@RequestParam("token") String token, @RequestParam("choiseid") long choiseid,
			@RequestParam("choiseitemid") long choiseitemid) {
		return null;
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam("token") String token, @RequestParam("choiseid") long choiseid) {
		return null;
	}

	@RequestMapping(value = "history/get", method = RequestMethod.GET)
	@ResponseBody
	public String getHistory(@RequestParam("token") String token,
			@RequestParam(value = "pageNo", required = true) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) int pageSize) {
		return "choise/history";
	}

	@RequestMapping(value = "chooseforme", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String chooseforme(@RequestParam("token") String token, @RequestParam("choises") String choises,
			@RequestParam(value = "extention", required = false) String extention) {
		return "choise/vote";
	}

}
