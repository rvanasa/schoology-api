package net.rvanasa.schoology.impl;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.SignatureType;
import org.scribe.oauth.OAuthService;

import net.rvanasa.schoology.SchoologyFlow;

public class OAuthSchoologyFlow implements SchoologyFlow
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
	
	private final SchoologyResourceLocator resourceLocator;
	
	private final OAuthService service;
	
	public OAuthSchoologyFlow(String domain, String key, String secret, String callbackUrl)
	{
		this(new SchoologyResourceLocator(domain), key, secret, callbackUrl);
	}
	
	public OAuthSchoologyFlow(SchoologyResourceLocator locator, String key, String secret, String callbackUrl)
	{
		this(locator, createService(locator, key, secret, callbackUrl));
	}
	
	public OAuthSchoologyFlow(SchoologyResourceLocator locator, OAuthService service)
	{
		this.resourceLocator = locator;
		this.service = service;
	}
	
	public SchoologyResourceLocator getResourceLocator()
	{
		return resourceLocator;
	}
	
	public OAuthService getService()
	{
		return service;
	}
	
	@Override
	public OAuthSchoologyToken createRequestToken()
	{
		return new OAuthSchoologyToken(this, getService().getRequestToken());
	}
}
