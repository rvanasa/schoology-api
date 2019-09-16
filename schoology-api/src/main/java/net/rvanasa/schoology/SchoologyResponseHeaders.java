package net.rvanasa.schoology;

import java.util.Map;

public interface SchoologyResponseHeaders
{
	public Map<String, String> getHeaders();
	
	public String getHeader(String header);
}
