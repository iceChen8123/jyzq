//package com.ice.jyzq.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.ice.jyzq.constant.ChoiseExpiredTime;
//import com.ice.jyzq.constant.VoteArea;
//import com.ice.jyzq.service.ManageService;
//import com.ice.jyzq.util.JsonMapper;
//import com.ice.server.bean.sys.ChoiseSubject;
//import com.ice.server.bean.sys.ChoiseType;
//import com.ice.server.bean.sys.City;
//
//@Controller
//public class SysInfoQueryController {
//
//	@Autowired
//	private ManageService manageService;
//
//	@RequestMapping(value = "choisetype/get", method = RequestMethod.POST)
//	@ResponseBody
//	public String getChoiseType() {
//		List<ChoiseType> choiseTypes = manageService.getChoiseTypes();
//		return JsonMapper.toJsonString(choiseTypes);
//	}
//
//	@RequestMapping(value = "subject/get", method = RequestMethod.POST)
//	@ResponseBody
//	public String getSubjects() {
//		List<ChoiseSubject> choiseSubjects = manageService.getSubjects();
//		return JsonMapper.toJsonString(choiseSubjects);
//	}
//
//	@RequestMapping(value = "subject/getbychoisecode", method = RequestMethod.POST)
//	@ResponseBody
//	public String getSubjects(@RequestParam("choiseCode") String choiseCode) {
//		List<ChoiseSubject> choiseSubjects = manageService.getSubjects(choiseCode);
//		return JsonMapper.toJsonString(choiseSubjects);
//	}
//
//	@RequestMapping(value = "choiseexpiredtime/get", method = RequestMethod.POST)
//	@ResponseBody
//	public String getChoiseExpiredTimes() {
//		List<Map<String, Object>> choiseExpiredTimes = ChoiseExpiredTime.getList();
//		return JsonMapper.toJsonString(choiseExpiredTimes);
//	}
//
//	@RequestMapping(value = "votearea/get", method = RequestMethod.POST)
//	@ResponseBody
//	public String getVoteAreas() {
//		List<Map<String, Object>> voteareaList = VoteArea.getList();
//		return JsonMapper.toJsonString(voteareaList);
//	}
//
//	@RequestMapping(value = "city/get", method = RequestMethod.POST)
//	@ResponseBody
//	public String getAddress() {
//		List<City> cities = manageService.getcities();
//		return JsonMapper.toJsonString(cities);
//	}
//}
