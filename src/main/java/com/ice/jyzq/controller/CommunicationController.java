package com.ice.jyzq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ice.jyzq.util.JsonMapper;

@Controller
@RequestMapping(value = "online")
public class CommunicationController {

	@RequestMapping(value = "some/get", method = RequestMethod.GET)
	@ResponseBody
	public String getSome(@RequestParam(value = "choiceType", required = false) String choiceType) {
		List<String> pList = new ArrayList<String>();
		pList.add("test1");
		pList.add("test2");
		pList.add("test3");
		pList.add("test4");
		pList.add("test5");
		return JsonMapper.toJsonString(pList);
	}
}
