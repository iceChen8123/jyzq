package com.ice.jyzq.controller.back;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ice.jyzq.service.AdviceService;
import com.ice.jyzq.util.JsonMapper;
import com.ice.server.bean.sys.Advice;

@Controller
@RequestMapping("b")
public class CommunicationController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AdviceService adviceService;

	@RequestMapping(value = "online/some/get", method = RequestMethod.GET)
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

	@RequestMapping(value = "advice", method = RequestMethod.GET)
	public String toAdvice() {
		return "advice";
	}

	@RequestMapping(value = "advice", method = RequestMethod.POST)
	public String advice(Model model, String title, String advice) {
		adviceService.save(title, advice);
		model.addAttribute("message", "谢陛下 (*_*)");
		return "forward:hello";
	}

	@RequestMapping(value = "advice/get", method = RequestMethod.GET)
	public String toGetAdvice() {
		return "advices";
	}

	@RequestMapping(value = "advice/get", method = RequestMethod.POST)
	@ResponseBody
	public String getAdvices(@RequestParam(value = "pageNo", required = true) int pageNo) {
		List<Advice> advices = adviceService.findLatestAdvices(pageNo, 10);
		return JsonMapper.toJsonString(advices);
	}
}
