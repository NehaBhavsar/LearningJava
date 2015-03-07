package com.tms.vo;

import java.util.List;

import com.tms.entity.TicketTxn;
import com.tms.util.Resp;

public class SearchTicketResp {

	private Resp resp;
	private long totalCount;
	private List<TicketTxn> ticketTxns;
	
	public SearchTicketResp(Resp resp) {
		super();
		this.resp = resp;
	}
	public Resp getResp() {
		return resp;
	}
	public void setResp(Resp resp) {
		this.resp = resp;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public List<TicketTxn> getTicketTxns() {
		return ticketTxns;
	}
	public void setTicketTxns(List<TicketTxn> ticketTxns) {
		this.ticketTxns = ticketTxns;
	}
	
}
