package net.rvanasa.schoology.impl;

import java.util.Map;

public class SchoologyResponseHeaders
{
	private final Map<String, String> headers;

	public SchoologyResponseHeaders(Map<String, String> headers)
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
