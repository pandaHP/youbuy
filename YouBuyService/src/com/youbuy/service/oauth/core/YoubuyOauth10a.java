package com.youbuy.service.oauth.core;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.youbuy.service.oauth.api.DefaultApi10aEx;

public class YoubuyOauth10a {

	public OAuthService service;
	public DefaultApi10aEx api10a;
	
	private Token accessToken;

	public YoubuyOauth10a(DefaultApi10aEx api10a) {
		this.service = new ServiceBuilder().provider(DefaultApi10aEx.class)
				.apiKey(api10a.getApiKey()).apiSecret(api10a.getApiSecret())
				.build();
	}

	public Token prepareForCall() {
		Token requestToken = service.getRequestToken();
		String authorizationUrl = service.getAuthorizationUrl(requestToken);
		try {
			Desktop.getDesktop().browse(new URI(authorizationUrl));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Verifier verifier = new Verifier(new Scanner(System.in).nextLine());
	    accessToken = service.getAccessToken(requestToken, verifier);
	    return accessToken;
	}
		 
}
