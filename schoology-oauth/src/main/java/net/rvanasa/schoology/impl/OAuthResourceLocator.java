package net.rvanasa.schoology.impl;

public abstract class OAuthResourceLocator
{
	public abstract String getDomain();
	
	public String getRequestUrlBase()
	{
		return "https://api.schoology.com/v1/";
	}
	
	public String getRequestUrl(String resource)
	{
		return getRequestUrlBase() + resource;
	}
}
