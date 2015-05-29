package com.ice.jyzq.controller.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.ice.jyzq.common.UserUtil;
import com.ice.jyzq.service.ChoiseService;
import com.ice.jyzq.util.JsonMapper;

@Controller
@RequestMapping(value = "b/choise")
public class ChoiseController {

	@Autowired
	private UserUtil userUtil;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ChoiseService choiseService;

	@RequestMapping(value = "new", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("choiseType") String choiseType, @RequestParam("title") String title,
			@RequestParam("choiseDesc") String choiseDesc) {
		List<String> choiseList = getChoisesFromRequest(request);
		logger.info("choiseType {} , choiceList {}", choiseType, JsonMapper.toJsonString(choiseList));
		choiseService.save(title, choiseType, choiseList, choiseDesc, userUtil.getCurrentUserName());
		model.addAttribute("message", "ok");
		return "home";
	}

	@RequestMapping(value = "vote", method = RequestMethod.GET)
	public String vote(@RequestParam("id") String id, Model model) {
		model.addAttribute("id", id);
		return "choise/vote";
	}

	@RequestMapping(value = "vote", method = RequestMethod.POST)
	@ResponseBody
	public String vote(@RequestParam("id") String choiseId, @RequestParam("choise") String choise) {
		logger.info("vote : {}  - {}", choiseId, choise);
		if(choiseService.checkHasVote(choiseId,choise)){
			return JsonMapper.toJsonString("您已经投过票了");
		}
		choiseService.vote(choiseId, choise);
		return JsonMapper.toJsonString("ok");
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

}
