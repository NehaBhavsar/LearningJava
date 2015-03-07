package com.tms;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tms.controller.LoginController;
import com.tms.dao.UserDao;
import com.tms.service.UserService;
import com.tms.vo.AuthResp;
import com.tms.vo.UserVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestHibernateConfig.class)
public class TestHibernate {

	Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	UserService userService;
	@Autowired
	LoginController controller;
	@Autowired
	UserDao userDao;

	
	@Test
	public void failIfRequiredObjectsAreNull() {
		Assert.assertNotNull(userService);
	}

	@Test
	public void testFindAllUser() {
		UserVO userVO = new UserVO();
		userVO.setUsername("admin1");
		userVO.setPassword("admin");
		AuthResp resp = userService.authUserservice(userVO);
		logger.info("MstUSer size :----------------------------------- "
				+ resp.getResp().getRespMsg());
		logger.info(resp.getUser());
		System.out.println("MstUSer size :----------------------------------- "
				+ resp.getResp().getRespMsg());

	}
	
	
}
