package com.ice.jyzq.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.ice.server.ChoiseType;

@Component
public class CommonInfoUtil {

	private static final List<ChoiseType> CHOICE_TYPE_LIST = new ArrayList<ChoiseType>();

	@PostConstruct
	public void init() {
		CHOICE_TYPE_LIST.addAll(Arrays.asList(ChoiseType.values()));
	}

	public static List<ChoiseType> getChoiceTypes() {
		return CHOICE_TYPE_LIST;
	}

}
