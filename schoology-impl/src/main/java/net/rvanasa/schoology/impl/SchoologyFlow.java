package net.rvanasa.schoology.impl;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.SignatureType;
import org.scribe.oauth.OAuthService;

import lombok.Getter;

public class SchoologyFlow
{
	public static OAuthService createService(SchoologyResourceLocator locator, String key, String secret, String callbackUrl)
	{
		return new ServiceBuilder()
				.provider(new OAuthSchoologyApi(locator))
				.apiKey(key)
				.apiSecret(secret)
				.callback(callbackUrl)
				.signatureType(SignatureType.Header)
				.build();
	}
	
	@Getter
	private final SchoologyResourceLocator resourceLocator;
	
	@Getter
	private final OAuthService service;
	
	public SchoologyFlow(String domain, String key, String secret, String callbackUrl)
	{
		this(new SchoologyResourceLocator(domain), key, secret, callbackUrl);
	}
	
	public SchoologyFlow(SchoologyResourceLocator locator, String key, String secret, String callbackUrl)
	{
		this(locator, createService(locator, key, secret, callbackUrl));
	}
	
	public SchoologyFlow(SchoologyResourceLocator locator, OAuthService service)
	{
		this.resourceLocator = locator;
		this.service = service;
	}
	
	public SchoologyToken createRequestToken()
	{
		return new SchoologyToken(this, getService().getRequestToken());
	}
}
