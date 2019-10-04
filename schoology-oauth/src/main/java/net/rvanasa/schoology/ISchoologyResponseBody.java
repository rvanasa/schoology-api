package net.rvanasa.schoology;

public interface ISchoologyResponseBody
{
	public ISchoologyContentType getContentType();
	
	public String getRawData();
	
	default ISchoologyNode parse()
	{
		return getContentType().getParser().parseNode(getRawData());
	}
}
