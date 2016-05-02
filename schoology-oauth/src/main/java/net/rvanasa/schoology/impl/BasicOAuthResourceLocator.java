package net.rvanasa.schoology.impl;

public class BasicOAuthResourceLocator extends OAuthResourceLocator
{
	private final String domain;
	
	public BasicOAuthResourceLocator(String domain)
	{
		this.domain = domain;
	}
	
	@Override
	public String getDomain()
	{
		return domain;
	}
}
