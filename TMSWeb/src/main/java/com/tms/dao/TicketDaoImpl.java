package com.tms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tms.controller.TicketController;
import com.tms.entity.MstStatus;
import com.tms.entity.MstTicket;
import com.tms.entity.MstUser;
import com.tms.entity.TicketTxn;
import com.tms.entity.TicketTxnRemark;
import com.tms.util.Constant;
import com.tms.vo.TicketVO;

@Repository
public class TicketDaoImpl implements TicketDao {

	Logger logger = Logger.getLogger(TicketController.class);
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<MstTicket> getAllTicketTypeList() {

		String hql = "SELECT ticket FROM MstTicket ticket";
		Query query = getSession().createQuery(hql);
		List<MstTicket> results = query.list();
//		System.out.println("*******************************************");
//		for (MstTicket ticket : results) {
//			System.out.println(ticket.getTicketId() + " ---------- " + ticket.getTicketType());
//		}
		return results;
	}

	public int cretatTicketTxn(TicketVO ticketVO) {
		// TODO Auto-generated method stub
		TicketTxn txn = new TicketTxn();
		txn.setMstTicket(ticketVO.getTicket());
		txn.setCreatedOn(new Date());
		
		MstUser user = (MstUser) getSession().get(MstUser.class, ticketVO.getUserId());
		txn.setMstUser4(user);
		
		MstStatus status =(MstStatus) getSession().get(MstStatus.class, Constant.OPEN);
		txn.setMstStatus(status);
		getSession().save(txn);
		
		TicketTxnRemark  remark = new TicketTxnRemark();
		remark.setMstTicket(ticketVO.getTicket());
		remark.setRemarkOn(new Date());
		remark.setTicketTxn(txn);
		remark.setUserId(user.getUserId());
		remark.setTikenRemarkDesc(ticketVO.getTicketDesc());
		List<TicketTxnRemark> remarks = new ArrayList<TicketTxnRemark>();
		remarks.add(remark);
		txn.setTicketTxnRemarks(remarks);
		getSession().save(remark);
		
		
		logger.info("Txn Ticket created successfully " + txn.getTxnId());
		
		logger.info("Remark Txn Ticket created successfully " + remark.getTikenRemarkId());
		return txn.getTxnId();
	}

	public List<TicketTxn> getAllTicketTxnList() {
		String hql = "SELECT ticket FROM TicketTxn ticket";
		Query query = getSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<TicketTxn> results = query.list();
		return results;
	}
}
