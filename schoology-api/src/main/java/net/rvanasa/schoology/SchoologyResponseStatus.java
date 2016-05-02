package net.rvanasa.schoology;

public interface SchoologyResponseStatus
{
	public int getCode();
	
	public String getMessage();
	
	public boolean isSuccess();
}
