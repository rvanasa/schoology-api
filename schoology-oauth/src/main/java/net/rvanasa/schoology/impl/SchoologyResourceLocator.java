package net.rvanasa.schoology.impl;

import lombok.Getter;

class SchoologyResourceLocator
{
	@Getter
	private final String domain;
	
	public SchoologyResourceLocator(String domain)
	{
		this.domain = domain;
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
