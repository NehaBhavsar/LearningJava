package com.tms.util;

public class Resp {

	private String respMsg;
	private ResponseCode respCode;
	
	public Resp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resp(String respMsg, ResponseCode respCode) {
		super();
		this.respMsg = respMsg;
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public ResponseCode getRespCode() {
		return respCode;
	}
	public void setRespCode(ResponseCode respCode) {
		this.respCode = respCode;
	}
	
	
}
