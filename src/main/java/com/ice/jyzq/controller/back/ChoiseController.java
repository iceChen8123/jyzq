package com.ice.jyzq.controller.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
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
import com.ice.jyzq.controller.util.ChoiseConvertUtil;
import com.ice.jyzq.controller.vo.ChoiseVo;
import com.ice.jyzq.service.ChoiseService;
import com.ice.jyzq.util.JsonMapper;
import com.ice.server.bean.Choise;

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
			@RequestParam("choiseCode") String choiseCode, @RequestParam("subjectId") Long subjectId,
			@RequestParam("title") String title,
			@RequestParam(value = "choiseDesc", required = false) String choiseDesc,
			@RequestParam("cityId") Integer cityId, @RequestParam("address") String address) {
		List<String> choiseList = getChoisesFromRequest(request);
		choiseService.save(title, choiseCode, subjectId, choiseList, choiseDesc, userUtil.getCurrentUserName(), cityId,
				address);
		model.addAttribute("message", "恭喜你,把纠结丢给大家了,哈哈@_@");
		return "home";
	}

	@RequestMapping(value = "chooseforme", method = { RequestMethod.GET, RequestMethod.POST })
	public String chooseforme(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("choiseCode") String choiseCode, @RequestParam("subjectId") Long subjectId,
			@RequestParam("title") String title,
			@RequestParam(value = "choiseDesc", required = false) String choiseDesc,
			@RequestParam("cityId") Integer cityId, @RequestParam("address") String address) {
		List<String> choiseList = getChoisesFromRequest(request);
		Choise choise = choiseService.save(title, choiseCode, subjectId, choiseList, choiseDesc,
				userUtil.getCurrentUserName(), cityId, address);
		model.addAttribute("message", "系统为你选的是: " + choiseList.get(RandomUtils.nextInt(choiseList.size())));
		model.addAttribute("id", choise.getId());
		return "choise/vote";
	}

	@RequestMapping(value = "history/my", method = RequestMethod.GET)
	public String tohistory() {
		return "choise/history";
	}

	@RequestMapping(value = "history/my", method = RequestMethod.POST)
	@ResponseBody
	public String history(@RequestParam(value = "choiseType", required = false) String choiseType,
			@RequestParam(value = "pageNo", required = true) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) int pageSize) {
		List<Choise> choises = choiseService.findMyChoises(choiseType, pageNo, pageSize);
		List<ChoiseVo> choisevos = ChoiseConvertUtil.convertToChoiseVos(choises);
		logger.debug("getSome page : {}; pageSize: {}, listsize: {}",
				new Object[] { pageNo, pageSize, choisevos.size() });
		return JsonMapper.toJsonString(choisevos);
	}

	@RequestMapping(value = "vote", method = RequestMethod.POST)
	@ResponseBody
	public String vote(@RequestParam("id") String choiseId, @RequestParam("subjectId") Long subjectId,
			@RequestParam("choise") String choise) {
		logger.info("vote : {}  - {}", choiseId, choise);
		if (choiseService.checkHasVote(choiseId, choise)) {
			return JsonMapper.toJsonString("您已经投过票了");
		}
		choiseService.vote(subjectId, choiseId, choise);
		return JsonMapper.toJsonString("谢谢,你正在拯救一个纠结中的生命^_^");
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

	@RequestMapping(value = "getlatestaddressinfo", method = RequestMethod.POST)
	@ResponseBody
	public String getlatestaddressinfo() {
		Map<String, Object> latestaddressinfo = new HashMap<String, Object>();
		latestaddressinfo.put("cityId", choiseService.getlatestCityId());
		latestaddressinfo.put("address", choiseService.getlatestaddress());
		return JsonMapper.toJsonString(latestaddressinfo);
	}

}
