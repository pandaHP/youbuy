package com.youbuy.service.oauth.api;
import org.scribe.model.Token;

public class VanclApi extends DefaultApi10aEx {

	private static final String REQUEST_TOKEN_URL = "http://p-api.gicp.net/oauthnew/request-token.ashx";
	private static final String ACCESS_TOKEN_URL = "http://p-api.gicp.net/oauthnew/access-token.ashx";
	private static final String AUTHORIZE_URL = "http://p-api.gicp.net/oauthnew/authorize.aspx?oauth_token=%s";
	private static final String ApiKey = "71bbb934079a1391c0e9e65bbaeae67c";
	private static final String ApiSecret = "6b56a04b96cacbcbeb31706901f607ad";
	
	@Override
	public String getRequestTokenEndpoint() {
		// TODO Auto-generated method stub
		return REQUEST_TOKEN_URL;
	}

	@Override
	public String getAccessTokenEndpoint() {
		// TODO Auto-generated method stub
		return ACCESS_TOKEN_URL;
	}

	@Override
	public String getAuthorizationUrl(Token requestToken) {
		// TODO Auto-generated method stub
		return String.format(AUTHORIZE_URL, requestToken.getToken());
	}

	@Override
	public String getApiKey() {
		// TODO Auto-generated method stub
		return ApiKey;
	}

	@Override
	public String getApiSecret() {
		// TODO Auto-generated method stub
		return ApiSecret;
	}

}
