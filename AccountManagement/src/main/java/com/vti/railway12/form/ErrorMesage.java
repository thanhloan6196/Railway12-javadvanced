package com.vti.railway12.form;

public class ErrorMesage {

	private int statusCode;
	private String messgage;
	
	public ErrorMesage(int statusCode, String messgage) {
		super();
		this.statusCode = statusCode;
		this.messgage = messgage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessgage() {
		return messgage;
	}

	public void setMessgage(String messgage) {
		this.messgage = messgage;
	}
	
	
	
	
}
