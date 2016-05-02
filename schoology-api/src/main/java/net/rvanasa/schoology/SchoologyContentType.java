package net.rvanasa.schoology;

public interface SchoologyContentType
{
	public String getID();
	
	public String getName();
	
	public SchoologyNodeParser getParser();
}
