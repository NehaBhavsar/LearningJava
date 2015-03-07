package com.tms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tms.service.UserService;
import com.tms.util.ResponseCode;
import com.tms.vo.AuthResp;
import com.tms.vo.UserVO;

@Controller
@RequestMapping("/tms")
public class LoginController {

	Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	UserService userService;

	@RequestMapping("/login")
	public ModelAndView loginpageForward() {
		logger.info("Inside Login page");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("login", model);
	}

	@RequestMapping(value = "/loginAuth", method = RequestMethod.POST)
	public ModelAndView loginAuth(@ModelAttribute UserVO userVO, HttpSession session) {
		logger.info("Inside do login action. ");
		Map<String, Object> model = new HashMap<String, Object>();
		String captcha=(String)session.getAttribute("captcha");
		/*if (userVO.getUsername() == null || userVO.getPassword() == null
                || userVO.getUsername().isEmpty() || userVO.getPassword().isEmpty()) 
        {
			session.setAttribute("message","Please enter all field value.");
			return new ModelAndView("login", model);
        } 
        else if (!userVO.getCaptchafield().equals(captcha)) 
        {
        	session.setAttribute("message","Please enter valid code.");
            return new ModelAndView("login", model);
        }*/
		AuthResp resp = userService.authUserservice(userVO);
		
		logger.info("Captcha from field : " + userVO.getCaptchafield());

		
		logger.info("String captcha : " + captcha);
		if (resp.getResp().getRespCode() == ResponseCode.SUCCESS) {
			logger.info("USer name " + resp.getUser().getUserName());
			logger.info("Role id : " + resp.getUser().getMstRole().getRoleId());
			session.setAttribute("username", resp.getUser().getUserName());
			session.setAttribute("userid", resp.getUser().getUserId());
			session.setAttribute("useremail", resp.getUser().getEmail_Id());
			session.setAttribute("ishouser", resp.getUser().getIsHoUser());
			session.setAttribute("roleId", resp.getUser().getMstRole().getRoleId());
			session.setAttribute("rolename", resp.getUser().getMstRole().getRoleName());
			return new ModelAndView("welcome", model);
		} else {
			return new ModelAndView("login", model);
		}

	}

	@RequestMapping("/home")
	public ModelAndView homePage() {
		logger.info("Inside home page");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("welcome", model);
	}
	@RequestMapping("/forgotpassword")
	public ModelAndView forgotpasswordForward() {
		logger.info("Inside forgot password page");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("forgotpassord", model);
	}
	
	@RequestMapping("/logout")
	public ModelAndView logoutAction() {
		logger.info("Inside logout action");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("login", model);
	}
}
