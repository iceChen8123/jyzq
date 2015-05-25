package com.ice.jyzq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "choise")
public class ChoiseController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "new", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("choiceType") String choiceType) {
		logger.info("choiceType {}", choiceType);
		List<String> choiseList = getChoisesFromRequest(request);
		logger.info("choiceList {}", JsonMapper.toJsonString(choiseList));
		return "redirect:/hello";
	}

	private List<String> getChoisesFromRequest(HttpServletRequest request) {
		List<String> rtnList = Lists.newArrayList();
		for (int a = 1; a < 7; a++) {
			if (StringUtils.isNotBlank(request.getParameter("choiceList" + a))) {
				rtnList.add(request.getParameter("choiceList" + a));
			}
		}
		return rtnList;
	}

	@RequestMapping(value = "some/get", method = { RequestMethod.GET, RequestMethod.POST })
	public String getSome(@RequestParam("choiceType") String choiceType) {
		return "redirect:/hello";
	}
}
