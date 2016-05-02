package net.rvanasa.schoology;

public interface SchoologyResponseHandler<T>
{
	public T handleResponse(SchoologyResponse response);
}
