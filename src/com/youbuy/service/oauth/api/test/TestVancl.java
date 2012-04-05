package com.youbuy.service.oauth.api.test;
import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.youbuy.service.oauth.api.VanclApi;

public class TestVancl {

	private static final String NETWORK_NAME = "Vancl";
	private static final String PROTECTED_RESOURCE_URL = "http://mapi.vancl.com/product/detail";
	private static final String API_KEY = "71bbb934079a1391c0e9e65bbaeae67c";
	private static final String API_SECRET = "6b56a04b96cacbcbeb31706901f607ad";

	public static void main(String[] args) {
		// Replace these with your own api key and secret
		String apiKey = API_KEY;
		String apiSecret = API_SECRET;
		OAuthService service = new ServiceBuilder().provider(VanclApi.class)
				.apiKey(apiKey).apiSecret(apiSecret)
				.callback("http://p-api.gicp.net").build();
		Scanner in = new Scanner(System.in);

		System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
		System.out.println();

		// Grab a request token.
		System.out.println("Fetching request token.");
		Token requestToken = service.getRequestToken();
		System.out.println("Got it ... ");
		System.out.println(requestToken.getToken());

		// Obtain the Authorization URL
		System.out.println("Fetching the Authorization URL...");
		String authorizationUrl = service.getAuthorizationUrl(requestToken);
		System.out.println("Got the Authorization URL!");
		System.out.println("Now go and authorize Scribe here:");
		System.out.println(authorizationUrl);
		System.out.println("And paste the authorization code here");
		System.out.print(">>");
		Verifier verifier = new Verifier(in.nextLine());
		System.out.println();

		// Trade the Request Token and Verfier for the Access Token
		System.out.println("Trading the Request Token for an Access Token...");
		Token accessToken = service.getAccessToken(requestToken, verifier);
		System.out.println("Got the Access Token!");
		System.out.println("(if your curious it looks like this: "
				+ accessToken + " )");
		System.out.println();

		// Now let's go and ask for a protected resource!
		System.out.println("Now we're going to access a protected resource...");
		OAuthRequest request = new OAuthRequest(Verb.GET,
				PROTECTED_RESOURCE_URL);

		request.addBodyParameter("productcode", "0051138");
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getCode());
		System.out.println(response.getBody());

		System.out.println();
		System.out
				.println("Thats it man! Go and build something awesome with Scribe! :)");

	}
}
