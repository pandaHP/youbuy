package com.youbuy.service.oauth.api;
import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class VanclApi extends DefaultApi10a {

	private static final String REQUEST_TOKEN_URL = "http://p-api.gicp.net/oauthnew/request-token.ashx";
	private static final String ACCESS_TOKEN_URL = "http://p-api.gicp.net/oauthnew/access-token.ashx";
	private static final String AUTHORIZE_URL = "http://p-api.gicp.net/oauthnew/authorize.aspx";

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
		return AUTHORIZE_URL;
	}

}
