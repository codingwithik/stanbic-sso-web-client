package com.stanbicibtc.webpoc.pojo;

import lombok.Data;

public @Data class GenericResponse {

	private String responseDescription;
	private String responseCode;
	private String responseStatus;

	public GenericResponse() {}

	
	public GenericResponse(String responseDescription) {
		super();
		this.responseDescription = responseDescription;
	}

	public GenericResponse(String responseDescription, String responseStatus, String responseCode) {
		super();
		this.responseDescription = responseDescription;
		this.responseStatus = responseStatus;
		this.responseCode = responseCode;
	}
}