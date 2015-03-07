package com.tms.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the mst_status database table.
 * 
 */
@Entity
@Table(name="mst_status")
@NamedQuery(name="MstStatus.findAll", query="SELECT m FROM MstStatus m")
public class MstStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="status_id")
	private int statusId;

	@Column(name="status_desc")
	private String statusDesc;

	@Column(name="status_name")
	private String statusName;

	//bi-directional many-to-one association to TicketTxn
	@OneToMany(mappedBy="mstStatus", fetch=FetchType.EAGER)
	private List<TicketTxn> ticketTxns;

	public MstStatus() {
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<TicketTxn> getTicketTxns() {
		return this.ticketTxns;
	}

	public void setTicketTxns(List<TicketTxn> ticketTxns) {
		this.ticketTxns = ticketTxns;
	}

	public TicketTxn addTicketTxn(TicketTxn ticketTxn) {
		getTicketTxns().add(ticketTxn);
		ticketTxn.setMstStatus(this);

		return ticketTxn;
	}

	public TicketTxn removeTicketTxn(TicketTxn ticketTxn) {
		getTicketTxns().remove(ticketTxn);
		ticketTxn.setMstStatus(null);

		return ticketTxn;
	}

}