package com.youbuy.service.oauth.api;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public abstract class DefaultApi10aEx extends DefaultApi10a {

	@Override
	public abstract String getRequestTokenEndpoint();

	@Override
	public abstract String getAccessTokenEndpoint();

	@Override
	public abstract String getAuthorizationUrl(Token requestToken);

	public abstract String getApiKey();

	public abstract String getApiSecret();
}
