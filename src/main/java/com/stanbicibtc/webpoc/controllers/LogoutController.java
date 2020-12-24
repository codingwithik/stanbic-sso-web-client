package com.stanbicibtc.webpoc.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stanbicibtc.webpoc.clients.KeycloakHttpClientServiceCaller;
import com.stanbicibtc.webpoc.pojo.GenericResponse;
import com.stanbicibtc.webpoc.pojo.LogoutRequest;
import com.stanbicibtc.webpoc.pojo.RespDTO;

@RestController
@RequestMapping(path = "api")
public class LogoutController {
		
	private KeycloakHttpClientServiceCaller handler;
	
	@PostMapping("/v1/logout")
	public GenericResponse logout(@RequestBody LogoutRequest request) {

		handler = new KeycloakHttpClientServiceCaller();
		
		//logout
		RespDTO response = handler.invalidateKeycloakToken(request);

		if(response == null) {
			return new GenericResponse("Invalid Credentials", "false", "101");
		}
		
		return new GenericResponse("Request Successful", "true", "000");
	}
	
}
