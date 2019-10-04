package net.rvanasa.schoology;

public interface ISchoologyToken
{
	public String getAuthorizationUrl();
	
	public ISchoologyRequestHandler createRequestHandler(String verifier);
}
