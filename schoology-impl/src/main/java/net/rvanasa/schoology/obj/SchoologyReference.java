package net.rvanasa.schoology.obj;

import net.rvanasa.schoology.impl.SchoologyRequestHandler;

/*
 * Used to make addition requests to the SchoologyRequestHandler from Schoology objects.
 * Any schoology object which needs to make additional requests extends this at some point.
 */
public abstract class SchoologyReference<T>
{
	
	protected SchoologyRequestHandler schoology;
	
	@SuppressWarnings("unchecked")
	public T reference(SchoologyRequestHandler schoology)
	{
		this.schoology = schoology;
		
		return (T) this;
	}
	
}
