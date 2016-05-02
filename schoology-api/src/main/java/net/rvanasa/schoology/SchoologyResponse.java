package net.rvanasa.schoology;

public interface SchoologyResponse
{
	public SchoologyResponseStatus getStatus();
	
	public SchoologyResponseBody getBody();
	
	public SchoologyResponse requireSuccess();
}
