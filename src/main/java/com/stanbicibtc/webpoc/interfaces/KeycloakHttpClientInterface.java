package com.stanbicibtc.webpoc.interfaces;

import com.stanbicibtc.webpoc.pojo.LogoutRequest;
import com.stanbicibtc.webpoc.pojo.RespDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface KeycloakHttpClientInterface {
	
	final static String INVALIDATE_TOKEN = "api/v1/onePass/logout";

	
    @POST(INVALIDATE_TOKEN)
    public Call<RespDTO> keycloakTokenLogout(@Body LogoutRequest request);
    
    
}
