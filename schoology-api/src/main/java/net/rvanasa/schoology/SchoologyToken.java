package net.rvanasa.schoology;

public interface SchoologyToken
{
	public String getAuthorizationUrl();
	
	public SchoologyRequestHandler createRequestHandler(String verifier);
}
