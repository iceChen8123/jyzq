package com.ice.jyzq.controller.back;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ice.jyzq.constant.ChoiseExpiredTime;
import com.ice.jyzq.constant.VoteArea;
import com.ice.jyzq.service.ManageService;
import com.ice.jyzq.util.JsonMapper;
import com.ice.server.bean.Address;
import com.ice.server.bean.sys.ChoiseSubject;
import com.ice.server.bean.sys.ChoiseType;
import com.ice.server.bean.sys.City;

@Controller
@RequestMapping("b")
public class ManageController {

	@Autowired
	private ManageService manageService;

	@RequestMapping(value = "manage", method = RequestMethod.GET)
	public String manage() {
		return "sys/manage";
	}

	@RequestMapping(value = "choiseType/new", method = RequestMethod.POST)
	public String addChoiseType(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("choiseCode") String choiseCode, @RequestParam("choiseName") String choiseName) {
		manageService.saveChoiseType(choiseCode, choiseName);
		return "sys/manage";
	}

	@RequestMapping(value = "choiseType/del", method = RequestMethod.GET)
	public String deleteChoiseType(@RequestParam("id") Long choiseTypeId) {
		manageService.deleteChoiseType(choiseTypeId);
		return "sys/manage";
	}

	@RequestMapping(value = "choiseType/renew", method = RequestMethod.GET)
	public String renewChoiseType(@RequestParam("id") Long choiseTypeId) {
		manageService.renewChoiseType(choiseTypeId);
		return "sys/manage";
	}

	@RequestMapping(value = "choiseSubject/new", method = RequestMethod.POST)
	public String addSubject(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("choiseType") String choiseCode, @RequestParam("subjectName") String subjectName,
			@RequestParam("expiredTime") Long expiredTime, @RequestParam("voteArea") String voteArea) {
		manageService.saveSubject(choiseCode, subjectName, expiredTime, voteArea);
		return "sys/manage";
	}

	@RequestMapping(value = "choiseSubject/del", method = RequestMethod.GET)
	public String deleteSubject(@RequestParam("id") Long choiseSubjectId) {
		manageService.deleteSubject(choiseSubjectId);
		return "sys/manage";
	}

	@RequestMapping(value = "choiseSubject/renew", method = RequestMethod.GET)
	public String renewSubject(@RequestParam("id") Long choiseSubjectId) {
		manageService.renewSubject(choiseSubjectId);
		return "sys/manage";
	}

	@RequestMapping(value = "choisetype/get", method = RequestMethod.POST)
	@ResponseBody
	public String getChoiseType() {
		List<ChoiseType> choiseTypes = manageService.getChoiseTypes();
		return JsonMapper.toJsonString(choiseTypes);
	}

	@RequestMapping(value = "subject/get", method = RequestMethod.POST)
	@ResponseBody
	public String getSubjects() {
		List<ChoiseSubject> choiseSubjects = manageService.getSubjects();
		return JsonMapper.toJsonString(choiseSubjects);
	}

	@RequestMapping(value = "subject/getbychoisecode", method = RequestMethod.POST)
	@ResponseBody
	public String getSubjects(@RequestParam("choiseCode") String choiseCode) {
		List<ChoiseSubject> choiseSubjects = manageService.getSubjects(choiseCode);
		return JsonMapper.toJsonString(choiseSubjects);
	}

	@RequestMapping(value = "choiseexpiredtime/get", method = RequestMethod.POST)
	@ResponseBody
	public String getChoiseExpiredTimes() {
		List<Map<String, Object>> choiseExpiredTimes = ChoiseExpiredTime.getList();
		return JsonMapper.toJsonString(choiseExpiredTimes);
	}

	@RequestMapping(value = "votearea/get", method = RequestMethod.POST)
	@ResponseBody
	public String getVoteAreas() {
		List<Map<String, Object>> voteareaList = VoteArea.getList();
		return JsonMapper.toJsonString(voteareaList);
	}

	@RequestMapping(value = "city/get", method = RequestMethod.POST)
	@ResponseBody
	public String getAddress() {
		List<City> cities = manageService.getcities();
		return JsonMapper.toJsonString(cities);
	}
}
