package net.rvanasa.schoology;

public interface ISchoologyResponseHandler<T>
{
	public T handleResponse(ISchoologyResponse response);
}
