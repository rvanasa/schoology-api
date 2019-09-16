package net.rvanasa.schoology;

public interface SchoologyResponse
{
	public SchoologyResponseStatus getStatus();
	
	public SchoologyResponseBody getBody();
	
	public SchoologyResponseHeaders getHeaders();
	
	public SchoologyResponse requireSuccess();
}
