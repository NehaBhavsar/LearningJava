package com.tms.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the mst_ticket database table.
 * 
 */
@Entity
@Table(name="mst_ticket")
@NamedQuery(name="MstTicket.findAll", query="SELECT m FROM MstTicket m")
public class MstTicket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int ticketId;

	@Column(name="ticket_desc")
	private String ticketDesc;

	@Column(name="ticket_type")
	private String ticketType;

	//bi-directional many-to-one association to TicketTxn
	@OneToMany(mappedBy="mstTicket", fetch=FetchType.EAGER)
	private List<TicketTxn> ticketTxns;

	//bi-directional many-to-one association to TicketTxnRemark
	@OneToMany(mappedBy="mstTicket", fetch=FetchType.EAGER)
	private List<TicketTxnRemark> ticketTxnRemarks;

	public MstTicket() {
	}

	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketDesc() {
		return this.ticketDesc;
	}

	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}

	public String getTicketType() {
		return this.ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public List<TicketTxn> getTicketTxns() {
		return this.ticketTxns;
	}

	public void setTicketTxns(List<TicketTxn> ticketTxns) {
		this.ticketTxns = ticketTxns;
	}

	public TicketTxn addTicketTxn(TicketTxn ticketTxn) {
		getTicketTxns().add(ticketTxn);
		ticketTxn.setMstTicket(this);

		return ticketTxn;
	}

	public TicketTxn removeTicketTxn(TicketTxn ticketTxn) {
		getTicketTxns().remove(ticketTxn);
		ticketTxn.setMstTicket(null);

		return ticketTxn;
	}

	public List<TicketTxnRemark> getTicketTxnRemarks() {
		return this.ticketTxnRemarks;
	}

	public void setTicketTxnRemarks(List<TicketTxnRemark> ticketTxnRemarks) {
		this.ticketTxnRemarks = ticketTxnRemarks;
	}

	public TicketTxnRemark addTicketTxnRemark(TicketTxnRemark ticketTxnRemark) {
		getTicketTxnRemarks().add(ticketTxnRemark);
		ticketTxnRemark.setMstTicket(this);

		return ticketTxnRemark;
	}

	public TicketTxnRemark removeTicketTxnRemark(TicketTxnRemark ticketTxnRemark) {
		getTicketTxnRemarks().remove(ticketTxnRemark);
		ticketTxnRemark.setMstTicket(null);

		return ticketTxnRemark;
	}

}