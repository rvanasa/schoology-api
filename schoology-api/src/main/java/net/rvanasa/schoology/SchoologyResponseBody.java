package net.rvanasa.schoology;

public interface SchoologyResponseBody
{
	public SchoologyContentType getContentType();
	
	public String getRawData();
	
	default SchoologyNode parse()
	{
		return getContentType().getParser().parse(getRawData());
	}
}
