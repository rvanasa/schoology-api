package net.rvanasa.schoology.impl;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import net.rvanasa.schoology.SchoologyRequestHandler;
import net.rvanasa.schoology.SchoologyToken;

public class OAuthSchoologyToken implements SchoologyToken
{
	private final OAuthSchoologyFlow flow;
	private final Token token;
	
	public OAuthSchoologyToken(OAuthSchoologyFlow flow, Token token)
	{
		this.flow = flow;
		this.token = token;
	}
	
	public OAuthSchoologyFlow getFlow()
	{
		return flow;
	}
	
	public Token getToken()
	{
		return token;
	}
	
	public OAuthService getService()
	{
		return getFlow().getService();
	}
	
	@Override
	public String getAuthorizationUrl()
	{
		return getService().getAuthorizationUrl(getToken());
	}
	
	@Override
	public SchoologyRequestHandler createRequestHandler(String verifier)
	{
		Token accessToken = getService().getAccessToken(getToken(), new Verifier(verifier));
		
		OAuthSchoologyRequestHandler handler = new OAuthSchoologyRequestHandler(getFlow().getResourceLocator(), getService());
		handler.setAccessToken(accessToken);
		return handler;
	}
}
