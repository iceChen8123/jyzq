package com.ice.jyzq.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ice.server.ChoiceType;

@Component
public class CommonInfoUtil {

	private static final List<ChoiceType> CHOICE_TYPE_LIST = new ArrayList<ChoiceType>();

	@PostConstruct
	public void init() {
		CHOICE_TYPE_LIST.addAll(Arrays.asList(ChoiceType.values()));
	}

	public static List<ChoiceType> getChoiceTypes() {

		return CHOICE_TYPE_LIST;
	}

}
