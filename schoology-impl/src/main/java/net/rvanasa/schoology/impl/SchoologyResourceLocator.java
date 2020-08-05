package net.rvanasa.schoology.impl;

import lombok.Getter;

public class SchoologyResourceLocator
{
	public String getRequestURLBase()
	{
		return "https://api.schoology.com/v1/";
	}
	
	public String getRequestURL(String resource)
	{
		return getRequestURLBase() + resource;
	}
}
