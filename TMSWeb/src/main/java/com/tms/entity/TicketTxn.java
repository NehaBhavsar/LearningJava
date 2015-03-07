package com.tms.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ticket_txn database table.
 * 
 */
@Entity
@Table(name="ticket_txn")
@NamedQuery(name="TicketTxn.findAll", query="SELECT t FROM TicketTxn t")
public class TicketTxn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="txn_id")
	private int txnId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="approved_on")
	private Date approvedOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="assigned_on")
	private Date assignedOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="closed_on")
	private Date closedOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="rejected_on")
	private Date rejectedOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="resoved_on")
	private Date resovedOn;

	//bi-directional many-to-one association to MstStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private MstStatus mstStatus;

	//bi-directional many-to-one association to MstTicket
	@ManyToOne
	@JoinColumn(name="ticket_id")
	private MstTicket mstTicket;

	//bi-directional many-to-one association to MstUser
	@ManyToOne
	@JoinColumn(name="closed_user_id")
	private MstUser mstUser1;

	//bi-directional many-to-one association to MstUser
	@ManyToOne
	@JoinColumn(name="approved_user_id")
	private MstUser mstUser2;

	//bi-directional many-to-one association to MstUser
	@ManyToOne
	@JoinColumn(name="assigned_user_id")
	private MstUser mstUser3;

	//bi-directional many-to-one association to MstUser
	@ManyToOne
	@JoinColumn(name="created_user_id")
	private MstUser mstUser4;

	//bi-directional many-to-one association to MstUser
	@ManyToOne
	@JoinColumn(name="rejected_user_id")
	private MstUser mstUser5;

	//bi-directional many-to-one association to MstUser
	@ManyToOne
	@JoinColumn(name="resolved_user_id")
	private MstUser mstUser6;

	//bi-directional many-to-one association to TicketTxnRemark
	@OneToMany(mappedBy="ticketTxn", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<TicketTxnRemark> ticketTxnRemarks;

	public TicketTxn() {
	}

	public int getTxnId() {
		return this.txnId;
	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	public Date getApprovedOn() {
		return this.approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	public Date getAssignedOn() {
		return this.assignedOn;
	}

	public void setAssignedOn(Date assignedOn) {
		this.assignedOn = assignedOn;
	}

	public Date getClosedOn() {
		return this.closedOn;
	}

	public void setClosedOn(Date closedOn) {
		this.closedOn = closedOn;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getRejectedOn() {
		return this.rejectedOn;
	}

	public void setRejectedOn(Date rejectedOn) {
		this.rejectedOn = rejectedOn;
	}

	public Date getResovedOn() {
		return this.resovedOn;
	}

	public void setResovedOn(Date resovedOn) {
		this.resovedOn = resovedOn;
	}

	public MstStatus getMstStatus() {
		return this.mstStatus;
	}

	public void setMstStatus(MstStatus mstStatus) {
		this.mstStatus = mstStatus;
	}

	public MstTicket getMstTicket() {
		return this.mstTicket;
	}

	public void setMstTicket(MstTicket mstTicket) {
		this.mstTicket = mstTicket;
	}

	public MstUser getMstUser1() {
		return this.mstUser1;
	}

	public void setMstUser1(MstUser mstUser1) {
		this.mstUser1 = mstUser1;
	}

	public MstUser getMstUser2() {
		return this.mstUser2;
	}

	public void setMstUser2(MstUser mstUser2) {
		this.mstUser2 = mstUser2;
	}

	public MstUser getMstUser3() {
		return this.mstUser3;
	}

	public void setMstUser3(MstUser mstUser3) {
		this.mstUser3 = mstUser3;
	}

	public MstUser getMstUser4() {
		return this.mstUser4;
	}

	public void setMstUser4(MstUser mstUser4) {
		this.mstUser4 = mstUser4;
	}

	public MstUser getMstUser5() {
		return this.mstUser5;
	}

	public void setMstUser5(MstUser mstUser5) {
		this.mstUser5 = mstUser5;
	}

	public MstUser getMstUser6() {
		return this.mstUser6;
	}

	public void setMstUser6(MstUser mstUser6) {
		this.mstUser6 = mstUser6;
	}

	public List<TicketTxnRemark> getTicketTxnRemarks() {
		return this.ticketTxnRemarks;
	}

	public void setTicketTxnRemarks(List<TicketTxnRemark> ticketTxnRemarks) {
		this.ticketTxnRemarks = ticketTxnRemarks;
	}

	public TicketTxnRemark addTicketTxnRemark(TicketTxnRemark ticketTxnRemark) {
		getTicketTxnRemarks().add(ticketTxnRemark);
		ticketTxnRemark.setTicketTxn(this);

		return ticketTxnRemark;
	}

	public TicketTxnRemark removeTicketTxnRemark(TicketTxnRemark ticketTxnRemark) {
		getTicketTxnRemarks().remove(ticketTxnRemark);
		ticketTxnRemark.setTicketTxn(null);

		return ticketTxnRemark;
	}

}