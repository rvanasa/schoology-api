package net.rvanasa.schoology.impl;

import java.util.Map;

public class BasicSchoologyResponseHeaders
{
	private final Map<String, String> headers;

	public BasicSchoologyResponseHeaders(Map<String, String> headers)
	{
		this.headers = headers;
	}

	public Map<String, String> getHeaders()
	{
		return headers;
	}

	public String getHeader(String header)
	{
		return headers.get(header);
	}
	
	
}
