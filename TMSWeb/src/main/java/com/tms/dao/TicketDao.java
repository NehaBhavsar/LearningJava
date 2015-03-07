package com.tms.dao;

import java.util.List;

import com.tms.entity.MstTicket;
import com.tms.entity.TicketTxn;
import com.tms.vo.TicketVO;

public interface TicketDao {

	public List<MstTicket> getAllTicketTypeList();

	public int cretatTicketTxn(TicketVO ticketVO);

	public List<TicketTxn> getAllTicketTxnList();
}
