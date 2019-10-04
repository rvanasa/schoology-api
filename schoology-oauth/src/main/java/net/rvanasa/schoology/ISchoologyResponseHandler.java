package net.rvanasa.schoology;

import net.rvanasa.schoology.impl.BasicSchoologyResponse;

public interface ISchoologyResponseHandler<T>
{
	public T handleResponse(BasicSchoologyResponse response);
}