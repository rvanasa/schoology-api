package net.rvanasa.schoology.impl;

import java.util.Map;

import net.rvanasa.schoology.ISchoologyResponseHeaders;

public class BasicSchoologyResponseHeaders implements ISchoologyResponseHeaders
{
	private final Map<String, String> headers;

	public BasicSchoologyResponseHeaders(Map<String, String> headers)
	{
		this.headers = headers;
	}

	@Override
	public Map<String, String> getHeaders() {
		return headers;
	}

	@Override
	public String getHeader(String header) {
		return headers.get(header);
	}
	
	
}
