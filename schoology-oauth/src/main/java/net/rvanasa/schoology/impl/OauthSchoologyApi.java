package net.rvanasa.schoology.impl;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class OAuthSchoologyApi extends DefaultApi10a
{
	private final OAuthResourceLocator resourceLocator;
	
	public OAuthSchoologyApi(OAuthResourceLocator resourceLocator)
	{
		this.resourceLocator = resourceLocator;
	}
	
	public OAuthResourceLocator getResourceLocator()
	{
		return resourceLocator;
	}
	
	@Override
	public String getRequestTokenEndpoint()
	{
		return getResourceLocator().getRequestUrl("oauth/request_token");
	}
	
	@Override
	public String getAccessTokenEndpoint()
	{
		return getResourceLocator().getRequestUrl("oauth/access_token");
	}
	
	@Override
	public String getAuthorizationUrl(Token token)
	{
		return getResourceLocator().getRequestUrl("oauth/authorize");
	}
}
