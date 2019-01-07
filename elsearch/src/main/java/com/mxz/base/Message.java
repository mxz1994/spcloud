package com.mxz.base;
/**
* <p>Title: Message.java</p>  
* <p>Description: </p>  
* @author mxz
* @date 2018年11月22日  
*/
public class Message {
	
	private String message;
	
	private Integer statusCode;
	
	private Object data;

	public Message(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public Message setData(Object data) {
		this.data = data;
		return this;
	}
	
	public static Message OK(Object data) {
		return new Message(200).setData(data);
	}
}
