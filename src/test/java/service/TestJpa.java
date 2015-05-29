//package service;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.ice.jyzq.service.ChoiseService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring-context.xml")
//public class TestJpa {
//
//	Logger logger = LoggerFactory.getLogger(getClass());
//
//	@Autowired
//	private ChoiseService choiseService;
//
//	@Test
//	public void test() {
//		// String choiseType = ChoiseType.Food.getChoiceCode();
//		// List<String> choiseList = new ArrayList<String>();
//		// choiseList.add("好吃的1");
//		// choiseList.add("好吃的2");
//		// choiseList.add("好吃的3");
//		// String userName = "test" + System.currentTimeMillis();
//		// logger.info(JsonMapper.toJsonString(choiseService.save("testTitle",
//		// choiseType, choiseList, "miaoshu", userName)));
//
//		choiseService.vote("11", "oooooo");
//	}
//}
