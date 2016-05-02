package net.rvanasa.schoology;

public interface SchoologyAccess
{
	public SchoologyResponse get(String resource);
	
	public SchoologyResponse multiget(String... resources);
	
	public SchoologyResponse post(String resource, String body);
	
	public SchoologyResponse options(String resource);
}
