package com.ice.jyzq.controller;

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

import com.ice.jyzq.common.CommonInfoUtil;
import com.ice.jyzq.controller.util.ChoiseConvertUtil;
import com.ice.jyzq.controller.vo.ChoiseVo;
import com.ice.jyzq.service.ChoiseService;
import com.ice.jyzq.service.ManageService;
import com.ice.jyzq.util.JsonMapper;
import com.ice.server.bean.Choise;

@Controller
@RequestMapping(value = "choise")
public class ChoiseQueryController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ChoiseService choiseService;

	@Autowired
	private ManageService manageService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String to(@RequestParam(value = "type", required = false) String choiseType, Model model) {
		model.addAttribute("subject", choiseType);
		return "forward:hello";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String toList(@RequestParam(value = "type", required = false) String choiseType, Model model) {
		model.addAttribute("subject", choiseType);
		return "choise/list";
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestParam("id") String id) {
		ChoiseVo choiseVo = ChoiseConvertUtil.convertToChoiseVo(choiseService.findById(Long.parseLong(id)));
		choiseVo.setCity(manageService.getcity(choiseVo.getCityId()));
		choiseVo.setAddress(manageService.getAddress(choiseVo.getAddressId()));
		choiseVo.setHasComment(CommonInfoUtil.getIfHasCommentBySubject(choiseVo.getSubjectId()));
		// choiseVo.setSubject(subject); not need
		return JsonMapper.toJsonString(choiseVo);
	}

	@RequestMapping(value = "some/get", method = { RequestMethod.GET, RequestMethod.POST })
	// 可以优化，已经过期或者关闭的，就不显示了
	@ResponseBody
	public String getSome(@RequestParam(value = "choiseType", required = false) String choiseType,
			@RequestParam(value = "pageNo", required = true) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "12", required = false) int pageSize) {
		List<Choise> choises = choiseService.findLatestChoises(choiseType, pageNo, pageSize);
		List<ChoiseVo> choisevos = ChoiseConvertUtil.convertToChoiseVos(choises);
		logger.debug("getSome page : {}; pageSize: {}, listsize: {}",
				new Object[] { pageNo, pageSize, choisevos.size() });
		return JsonMapper.toJsonString(choisevos);
	}
}
