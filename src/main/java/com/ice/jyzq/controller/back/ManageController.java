package com.ice.jyzq.controller.back;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ice.jyzq.service.ManageService;

@Controller
@RequestMapping("b")
public class ManageController {

	@Autowired
	private ManageService manageService;

	@RequestMapping(value = "manage", method = RequestMethod.GET)
	public String manage() {
		return "sys/manage";
	}

	@RequestMapping(value = "manage/online", method = RequestMethod.GET)
	public String online() {
		return "sys/online";
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

}
