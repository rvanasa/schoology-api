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
	
	public String getRequestURLBase()
	{
		return "https://api.schoology.com/v1/";
	}
	
	public String getRequestURL(String resource)
	{
		return getRequestURLBase() + resource;
	}
}
