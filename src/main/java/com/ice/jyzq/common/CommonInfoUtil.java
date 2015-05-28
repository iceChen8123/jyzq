package com.ice.jyzq.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ice.jyzq.util.JsonMapper;
import com.ice.server.bean.ChoiseType;
import com.ice.server.dao.ChoiseTypeDao;

@Component
public class CommonInfoUtil {

	Logger logger = LoggerFactory.getLogger(getClass());

	private static final List<ChoiseType> CHOICE_TYPE_LIST = new ArrayList<ChoiseType>();

	@Autowired(required = true)
	private ChoiseTypeDao choiseTypeDao;

	@PostConstruct
	public void init() {
		Iterator<ChoiseType> choiseIterable = choiseTypeDao.findAll().iterator();
		while (choiseIterable.hasNext()) {
			CHOICE_TYPE_LIST.add(choiseIterable.next());
		}
		logger.info("init ok {}", JsonMapper.toJsonString(CHOICE_TYPE_LIST));
	}

	public static List<ChoiseType> getChoiceTypes() {
		return CHOICE_TYPE_LIST;
	}

}
