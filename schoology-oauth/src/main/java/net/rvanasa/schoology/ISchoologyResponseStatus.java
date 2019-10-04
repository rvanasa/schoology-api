package net.rvanasa.schoology;

public interface ISchoologyResponseStatus
{
	public int getCode();
	
	public String getMessage();
	
	public boolean isSuccess();
}
