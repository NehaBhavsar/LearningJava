package com.tms.vo;

import com.tms.entity.MstTicket;

public class TicketVO {

	private MstTicket ticket;
	private String ticketDesc;
	private int userId;

	public MstTicket getTicket() {
		return ticket;
	}

	public void setTicket(MstTicket ticket) {
		this.ticket = ticket;
	}

	public String getTicketDesc() {
		return ticketDesc;
	}

	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
