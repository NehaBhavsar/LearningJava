package com.tms.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mst_user database table.
 * 
 */
@Entity
@Table(name="mst_user")
@NamedQuery(name="MstUser.findAll", query="SELECT m FROM MstUser m")
public class MstUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private String email_Id;

	@Column(name="is_ho_user")
	private String isHoUser;

	@Column(name="pass_code")
	private String passCode;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to MstRole
	@ManyToOne
	@JoinColumn(name="role_id")
	private MstRole mstRole;

	//bi-directional many-to-one association to TicketTxn
	@OneToMany(mappedBy="mstUser1", fetch=FetchType.EAGER)
	private List<TicketTxn> ticketTxns1;

	//bi-directional many-to-one association to TicketTxn
	@OneToMany(mappedBy="mstUser2", fetch=FetchType.EAGER)
	private List<TicketTxn> ticketTxns2;

	//bi-directional many-to-one association to TicketTxn
	@OneToMany(mappedBy="mstUser3", fetch=FetchType.EAGER)
	private List<TicketTxn> ticketTxns3;

	//bi-directional many-to-one association to TicketTxn
	@OneToMany(mappedBy="mstUser4", fetch=FetchType.EAGER)
	private List<TicketTxn> ticketTxns4;

	//bi-directional many-to-one association to TicketTxn
	@OneToMany(mappedBy="mstUser5", fetch=FetchType.EAGER)
	private List<TicketTxn> ticketTxns5;

	//bi-directional many-to-one association to TicketTxn
	@OneToMany(mappedBy="mstUser6", fetch=FetchType.EAGER)
	private List<TicketTxn> ticketTxns6;

	public MstUser() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getEmail_Id() {
		return this.email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getIsHoUser() {
		return this.isHoUser;
	}

	public void setIsHoUser(String isHoUser) {
		this.isHoUser = isHoUser;
	}

	public String getPassCode() {
		return this.passCode;
	}

	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public MstRole getMstRole() {
		return this.mstRole;
	}

	public void setMstRole(MstRole mstRole) {
		this.mstRole = mstRole;
	}

	public List<TicketTxn> getTicketTxns1() {
		return this.ticketTxns1;
	}

	public void setTicketTxns1(List<TicketTxn> ticketTxns1) {
		this.ticketTxns1 = ticketTxns1;
	}

	public TicketTxn addTicketTxns1(TicketTxn ticketTxns1) {
		getTicketTxns1().add(ticketTxns1);
		ticketTxns1.setMstUser1(this);

		return ticketTxns1;
	}

	public TicketTxn removeTicketTxns1(TicketTxn ticketTxns1) {
		getTicketTxns1().remove(ticketTxns1);
		ticketTxns1.setMstUser1(null);

		return ticketTxns1;
	}

	public List<TicketTxn> getTicketTxns2() {
		return this.ticketTxns2;
	}

	public void setTicketTxns2(List<TicketTxn> ticketTxns2) {
		this.ticketTxns2 = ticketTxns2;
	}

	public TicketTxn addTicketTxns2(TicketTxn ticketTxns2) {
		getTicketTxns2().add(ticketTxns2);
		ticketTxns2.setMstUser2(this);

		return ticketTxns2;
	}

	public TicketTxn removeTicketTxns2(TicketTxn ticketTxns2) {
		getTicketTxns2().remove(ticketTxns2);
		ticketTxns2.setMstUser2(null);

		return ticketTxns2;
	}

	public List<TicketTxn> getTicketTxns3() {
		return this.ticketTxns3;
	}

	public void setTicketTxns3(List<TicketTxn> ticketTxns3) {
		this.ticketTxns3 = ticketTxns3;
	}

	public TicketTxn addTicketTxns3(TicketTxn ticketTxns3) {
		getTicketTxns3().add(ticketTxns3);
		ticketTxns3.setMstUser3(this);

		return ticketTxns3;
	}

	public TicketTxn removeTicketTxns3(TicketTxn ticketTxns3) {
		getTicketTxns3().remove(ticketTxns3);
		ticketTxns3.setMstUser3(null);

		return ticketTxns3;
	}

	public List<TicketTxn> getTicketTxns4() {
		return this.ticketTxns4;
	}

	public void setTicketTxns4(List<TicketTxn> ticketTxns4) {
		this.ticketTxns4 = ticketTxns4;
	}

	public TicketTxn addTicketTxns4(TicketTxn ticketTxns4) {
		getTicketTxns4().add(ticketTxns4);
		ticketTxns4.setMstUser4(this);

		return ticketTxns4;
	}

	public TicketTxn removeTicketTxns4(TicketTxn ticketTxns4) {
		getTicketTxns4().remove(ticketTxns4);
		ticketTxns4.setMstUser4(null);

		return ticketTxns4;
	}

	public List<TicketTxn> getTicketTxns5() {
		return this.ticketTxns5;
	}

	public void setTicketTxns5(List<TicketTxn> ticketTxns5) {
		this.ticketTxns5 = ticketTxns5;
	}

	public TicketTxn addTicketTxns5(TicketTxn ticketTxns5) {
		getTicketTxns5().add(ticketTxns5);
		ticketTxns5.setMstUser5(this);

		return ticketTxns5;
	}

	public TicketTxn removeTicketTxns5(TicketTxn ticketTxns5) {
		getTicketTxns5().remove(ticketTxns5);
		ticketTxns5.setMstUser5(null);

		return ticketTxns5;
	}

	public List<TicketTxn> getTicketTxns6() {
		return this.ticketTxns6;
	}

	public void setTicketTxns6(List<TicketTxn> ticketTxns6) {
		this.ticketTxns6 = ticketTxns6;
	}

	public TicketTxn addTicketTxns6(TicketTxn ticketTxns6) {
		getTicketTxns6().add(ticketTxns6);
		ticketTxns6.setMstUser6(this);

		return ticketTxns6;
	}

	public TicketTxn removeTicketTxns6(TicketTxn ticketTxns6) {
		getTicketTxns6().remove(ticketTxns6);
		ticketTxns6.setMstUser6(null);

		return ticketTxns6;
	}

}