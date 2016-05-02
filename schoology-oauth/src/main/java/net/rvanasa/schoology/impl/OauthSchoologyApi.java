package net.rvanasa.schoology.impl;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class OauthSchoologyApi extends DefaultApi10a
{
	private final String domain;
	
	public OauthSchoologyApi(String domain)
	{
		this.domain = domain;
	}
	
	@Override
	public String getRequestTokenEndpoint()
	{
		return "https://api.schoology.com/v1/oauth/request_token";
	}
	
	@Override
	public String getAccessTokenEndpoint()
	{
		return "https://api.schoology.com/v1/oauth/access_token";
	}
	
	@Override
	public String getAuthorizationUrl(Token token)
	{
		return "https://" + domain + ".schoology.com/oauth/authorize";
	}
}
