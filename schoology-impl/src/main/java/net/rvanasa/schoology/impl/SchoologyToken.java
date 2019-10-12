package net.rvanasa.schoology.impl;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import lombok.Getter;
import net.rvanasa.schoology.ISchoologyRequestHandler;

public class SchoologyToken
{
	@Getter
	private final SchoologyFlow flow;
	@Getter
	private final Token token;
	
	public SchoologyToken(SchoologyFlow flow, Token token)
	{
		this.flow = flow;
		this.token = token;
	}
	
	public OAuthService getService()
	{
		return getFlow().getService();
	}
	
	public String getAuthorizationUrl()
	{
		return getService().getAuthorizationUrl(getToken());
	}
	
	public ISchoologyRequestHandler createRequestHandler(String verifier)
	{
		Token accessToken = getService().getAccessToken(getToken(), new Verifier(verifier));
		
		SchoologyRequestHandler handler = new SchoologyRequestHandler(getFlow().getResourceLocator(), getService());
		handler.setAccessToken(accessToken);
		return handler;
	}
}
