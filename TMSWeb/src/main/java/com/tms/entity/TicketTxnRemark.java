package com.tms.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the ticket_txn_remark database table.
 * 
 */
@Entity
@Table(name = "ticket_txn_remark")
@NamedQuery(name = "TicketTxnRemark.findAll", query = "SELECT t FROM TicketTxnRemark t")
public class TicketTxnRemark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tiken_remark_id")
	private int tikenRemarkId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "remark_on")
	private Date remarkOn;

	@Column(name = "tiken_remark_desc")
	private String tikenRemarkDesc;

	@Column(name = "user_id")
	private int userId;

	// bi-directional many-to-one association to MstTicket
	@ManyToOne
	@JoinColumn(name = "tiken_id")
	private MstTicket mstTicket;

	// bi-directional many-to-one association to TicketTxn
	@ManyToOne
	@JoinColumn(name="ticket_txn_id")
	private TicketTxn ticketTxn;

	public TicketTxnRemark() {
	}

	public int getTikenRemarkId() {
		return this.tikenRemarkId;
	}

	public void setTikenRemarkId(int tikenRemarkId) {
		this.tikenRemarkId = tikenRemarkId;
	}

	public Date getRemarkOn() {
		return this.remarkOn;
	}

	public void setRemarkOn(Date remarkOn) {
		this.remarkOn = remarkOn;
	}

	public String getTikenRemarkDesc() {
		return this.tikenRemarkDesc;
	}

	public void setTikenRemarkDesc(String tikenRemarkDesc) {
		this.tikenRemarkDesc = tikenRemarkDesc;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public MstTicket getMstTicket() {
		return this.mstTicket;
	}

	public void setMstTicket(MstTicket mstTicket) {
		this.mstTicket = mstTicket;
	}

	public TicketTxn getTicketTxn() {
		return this.ticketTxn;
	}

	public void setTicketTxn(TicketTxn ticketTxn) {
		this.ticketTxn = ticketTxn;
	}

}