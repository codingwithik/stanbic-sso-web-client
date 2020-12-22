package com.stanbicibtc.webpoc.clients;


import com.stanbicibtc.webpoc.clients.init.KeycloakApiInit;
import com.stanbicibtc.webpoc.interfaces.KeycloakHttpClientInterface;
import com.stanbicibtc.webpoc.pojo.LogoutRequest;
import com.stanbicibtc.webpoc.pojo.RespDTO;

import retrofit2.Call;
import retrofit2.Response;


public class KeycloakHttpClientServiceCaller {
	
	public RespDTO invalidateKeycloakToken(LogoutRequest request) {
		
		KeycloakHttpClientInterface service = KeycloakApiInit.createService(KeycloakHttpClientInterface.class);

		Call<RespDTO> callAsync = service.keycloakTokenLogout(request);

		try {
			Response<RespDTO> response = callAsync.execute();

			return response.body();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
}
