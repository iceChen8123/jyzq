//package com.ice.jyzq.common;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.ice.jyzq.util.JsonMapper;
//import com.ice.server.bean.sys.ChoiseSubject;
//import com.ice.server.bean.sys.ChoiseType;
//import com.ice.server.dao.sys.ChoiseSubjectDao;
//import com.ice.server.dao.sys.ChoiseTypeDao;
//
//@Component
//public class CommonInfoUtil {
//
//	Logger logger = LoggerFactory.getLogger(getClass());
//
//	private static List<ChoiseType> CHOICE_TYPE_LIST = new ArrayList<ChoiseType>();
//	private static Map<Long, ChoiseSubject> CHOICE_SUBJECT_MAP = new HashMap<Long, ChoiseSubject>();
//
//	@Autowired(required = true)
//	private ChoiseTypeDao choiseTypeDao;
//
//	@Autowired(required = true)
//	private ChoiseSubjectDao choiseSubjectDao;
//
////	@PostConstruct
////	public void init() {
////		List<ChoiseType> choice_type_list = new ArrayList<ChoiseType>();
////		Iterator<ChoiseType> choiseIterable = choiseTypeDao.findAll().iterator();
////		while (choiseIterable.hasNext()) {
////			ChoiseType choiseType = choiseIterable.next();
////			if (choiseType.isOk()) {
////				choice_type_list.add(choiseType);
////			}
////		}
////		CHOICE_TYPE_LIST = choice_type_list;
////
////		Iterator<ChoiseSubject> choisesubjectIterator = choiseSubjectDao.findAll().iterator();
////		while (choisesubjectIterator.hasNext()) {
////			ChoiseSubject choiseSubject = choisesubjectIterator.next();
////			CHOICE_SUBJECT_MAP.put(choiseSubject.getId(), choiseSubject);
////		}
////		logger.debug("init ok {}", JsonMapper.toJsonString(CHOICE_TYPE_LIST));
////	}
//
//	@Scheduled(fixedDelay = 60 * 1000)
//	private void refresh() {
//		init();
//		//logger.info("refresh at : " + new Date());
//	}
//
//	public static List<ChoiseType> getChoiceTypes() {
//		return CHOICE_TYPE_LIST;
//	}
//
//	public static Integer getIfHasCommentBySubject(Long subjectId) {
//		if (CHOICE_SUBJECT_MAP.containsKey(subjectId)) {
//			return CHOICE_SUBJECT_MAP.get(subjectId).getHasComment();
//		}
//		return 0;
//	}
//
//}
