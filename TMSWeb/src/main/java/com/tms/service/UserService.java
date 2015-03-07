package com.tms.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.entity.MstUser;
import com.tms.util.Resp;
import com.tms.util.ResponseCode;
import com.tms.vo.AuthResp;
import com.tms.vo.UserVO;
import com.tms.controller.LoginController;
import com.tms.dao.UserDao;

@Service
@Transactional(readOnly = true)
public class UserService {
	Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	UserDao userDao;
	
	@Transactional
	public AuthResp authUserservice(UserVO userVO) {
		Resp resp = new Resp();
		AuthResp authResp = new AuthResp();
		logger.info("Inside UserService : " +userVO.getUsername());
		MstUser user = userDao.authUser(userVO.getUsername());
		if(null != user){
			if(! userVO.getPassword().trim().equalsIgnoreCase(user.getPassCode().trim())){
				resp.setRespCode(ResponseCode.FAILURE);
				resp.setRespMsg("Incorrect Password.");
				authResp.setResp(resp);
				return authResp;
			}else{
				resp.setRespCode(ResponseCode.SUCCESS);
				resp.setRespMsg("User Found .");
				authResp.setResp(resp);
				authResp.setUser(user);
				return authResp;
			}
		}else{
			resp.setRespCode(ResponseCode.FAILURE);
			resp.setRespMsg("Invalid User.");
			authResp.setResp(resp);
			return authResp;
		}
		
	}
	
}
