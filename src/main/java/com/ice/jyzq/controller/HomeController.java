package com.ice.jyzq.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ice.server.ChoiceType;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private static final List<ChoiceType> CHOICE_TYPE_LIST = new ArrayList<ChoiceType>();

	@PostConstruct
	public void init() {
		CHOICE_TYPE_LIST.addAll(Arrays.asList(ChoiceType.values()));
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/hello", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Locale locale, Model model) {
		return "home";
	}
}
