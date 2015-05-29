package com.ice.jyzq.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
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

import com.ice.jyzq.controller.vo.ChoiseVo;
import com.ice.jyzq.service.ChoiseService;
import com.ice.jyzq.util.JsonMapper;
import com.ice.server.bean.Choise;

@Controller
@RequestMapping(value = "choise")
public class ChoiseQueryController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ChoiseService choiseService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String to(@RequestParam("type") String choiseType, Model model) {
		model.addAttribute("subject", choiseType);
		return "forward:hello";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String toList(@RequestParam("type") String choiseType, Model model) {
		model.addAttribute("subject", choiseType);
		return "choise/list";
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam("id") String id) {
		return JsonMapper.toJsonString(convertToChoiseVo(choiseService.findById(Long.parseLong(id))));
	}

	@RequestMapping(value = "some/get", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getSome(@RequestParam(value = "choiseType") String choiseType,
			@RequestParam(value = "pageNo", required = true) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) int pageSize) {
		List<Choise> choises = choiseService.findLatestChoises(choiseType, pageNo, pageSize);
		List<ChoiseVo> choisevos = convertToChoiseVos(choises);
		logger.info("getSome page : {}; pageSize: {}, listsize: {}",
				new Object[] { pageNo, pageSize, choisevos.size() });
		return JsonMapper.toJsonString(choisevos);
	}

	private List<ChoiseVo> convertToChoiseVos(List<Choise> choises) {
		List<ChoiseVo> rtnList = new ArrayList<ChoiseVo>();
		for (Choise choise : choises) {
			ChoiseVo choiseVo = convertToChoiseVo(choise);
			rtnList.add(choiseVo);
		}
		return rtnList;
	}

	private ChoiseVo convertToChoiseVo(Choise choise) {
		ChoiseVo choiseVo = new ChoiseVo();
		try {
			BeanUtils.copyProperties(choiseVo, choise);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		String[] choiseTemps = choise.getChoises().split(ChoiseService.CHOISES_SPLIT_SEPARATOR);
		String[] voteTemps = choise.getVotes().split(ChoiseService.VOTE_SPLIT_SEPARATOR);
		int index = 0;
		for (String choiseTemp : choiseTemps) {
			if (StringUtils.isNotBlank(choiseTemp)) {
				choiseVo.addChoiseAndVote(choiseTemp, voteTemps[index]);
			}
			index++;
		}
		return choiseVo;
	}
}
