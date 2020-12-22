package com.stanbicibtc.webpoc.pojo;

import lombok.Data;

public @Data class RespDTO {
	
	private String responseCode;
	private String responseDescription;
	private Object responsePayload;
	private String responseStatus;
}
