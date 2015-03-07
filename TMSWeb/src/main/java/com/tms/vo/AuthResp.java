package com.tms.vo;

import com.tms.entity.MstUser;
import com.tms.util.Resp;

public class AuthResp {
	private MstUser user;
	private Resp resp;
	public MstUser getUser() {
		return user;
	}
	public void setUser(MstUser user) {
		this.user = user;
	}
	public Resp getResp() {
		return resp;
	}
	public void setResp(Resp resp) {
		this.resp = resp;
	}
	
}
