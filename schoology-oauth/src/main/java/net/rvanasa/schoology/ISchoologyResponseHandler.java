package net.rvanasa.schoology;

import net.rvanasa.schoology.impl.SchoologyResponse;

public interface ISchoologyResponseHandler<T>
{
	public T handleResponse(SchoologyResponse response);
}