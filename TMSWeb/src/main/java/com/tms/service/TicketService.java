package com.tms.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.controller.TicketController;
import com.tms.dao.TicketDao;
import com.tms.entity.MstTicket;
import com.tms.entity.TicketTxn;
import com.tms.util.Resp;
import com.tms.util.ResponseCode;
import com.tms.vo.SearchTicketResp;
import com.tms.vo.TicketVO;

@Service
@Transactional(readOnly = true)
public class TicketService {

	@Autowired
	TicketDao ticketDao;
	Logger logger = Logger.getLogger(TicketController.class);
	public List<MstTicket> getAllTicketType() {		
		return ticketDao.getAllTicketTypeList();
	}
	@Transactional
	public int createTicketTxn(TicketVO ticketVO) {
		return ticketDao.cretatTicketTxn(ticketVO);
	}
	public SearchTicketResp getAllTicketTxn() {
		SearchTicketResp resp = null;
		List<TicketTxn>  ticketTxns = ticketDao.getAllTicketTxnList();
		if(ticketTxns.size() >0){
					
			resp = new SearchTicketResp(new Resp("Ticket List Found.", ResponseCode.SUCCESS));
			resp.setTicketTxns(ticketTxns);
			resp.setTotalCount(ticketTxns.size());
			return resp;
		}else{
			resp = new SearchTicketResp(new Resp("Ticket List not Found.", ResponseCode.FAILURE));
			return resp;
		}
		
	}

}
