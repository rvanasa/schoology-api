package net.rvanasa.schoology.impl;

class SchoologyResourceLocator
{
	private final String domain;
	
	public SchoologyResourceLocator(String domain)
	{
		this.domain = domain;
	}
	
	public String getDomain()
	{
		return domain;
	}
	
	public String getRequestUrlBase()
	{
		return "https://api.schoology.com/v1/";
	}
	
	public String getRequestUrl(String resource)
	{
		return getRequestUrlBase() + resource;
	}
}
