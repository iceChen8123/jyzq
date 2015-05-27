package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ice.jyzq.service.UserService;
import com.ice.jyzq.util.JsonMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserServiceTest {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	@Test
	public void test() {
//		String userName = "test" + System.currentTimeMillis();
//		String password = "hahaha";
//		logger.info(JsonMapper.toJsonString(userService.save(userName, password)));
//		logger.info(JsonMapper.toJsonString(userService.findByUserName(userName)));
//
//		logger.info(userName + " exists: " + JsonMapper.toJsonString(userService.ifUserExists(userName)));
		
		userService.updateUserLoginInfo(12L);
	}
}
