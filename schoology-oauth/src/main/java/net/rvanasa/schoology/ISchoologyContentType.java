package net.rvanasa.schoology;

public interface ISchoologyContentType
{
	public String getID();
	
	public String getName();
	
	public ISchoologyNodeParser getParser();
}
