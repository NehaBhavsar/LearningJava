package com.tms.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.controller.LoginController;
import com.tms.entity.MstUser;

@Repository
public class UserDaoImpl implements UserDao {

	Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public MstUser authUser(String userName) {
		logger.info("Inside user dao -----" + userName);
		String hql = "FROM MstUser WHERE userName = :userName";

		Query query = getSession().createQuery(hql);
		query.setString("userName", userName);
		logger.info(query.list().size() + "---------");
		MstUser user = (MstUser) query.uniqueResult();
		if (null != user) {
			logger.info("User found with name in Database: " + user.getUserName());
			return user;
		} else {
			return null;
		}
	}

}
