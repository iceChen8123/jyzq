package server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ice.server.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestJpa {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDao userDao;

	@Test
	public void test() {
		logger.info(userDao.count() + "");
	}

}
