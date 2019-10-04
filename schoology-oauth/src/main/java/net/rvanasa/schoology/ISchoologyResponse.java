package net.rvanasa.schoology;

public interface ISchoologyResponse
{
	public ISchoologyResponseStatus getStatus();
	
	public ISchoologyResponseBody getBody();
	
	public ISchoologyResponseHeaders getHeaders();
	
	public ISchoologyResponse requireSuccess();
}
