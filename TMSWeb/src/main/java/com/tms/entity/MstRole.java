package com.tms.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_role database table.
 * 
 */
@Entity
@Table(name="mst_role")
@NamedQuery(name="MstRole.findAll", query="SELECT m FROM MstRole m")
public class MstRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;

	@Column(name="role_desc")
	private String roleDesc;

	@Column(name="role_name")
	private String roleName;

	//bi-directional many-to-one association to MstUser
	@OneToMany(mappedBy="mstRole", fetch=FetchType.EAGER)
	private List<MstUser> mstUsers;

	public MstRole() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<MstUser> getMstUsers() {
		return this.mstUsers;
	}

	public void setMstUsers(List<MstUser> mstUsers) {
		this.mstUsers = mstUsers;
	}

	public MstUser addMstUser(MstUser mstUser) {
		getMstUsers().add(mstUser);
		mstUser.setMstRole(this);

		return mstUser;
	}

	public MstUser removeMstUser(MstUser mstUser) {
		getMstUsers().remove(mstUser);
		mstUser.setMstRole(null);

		return mstUser;
	}

}