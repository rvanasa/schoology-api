package net.rvanasa.schoology.obj;

import java.lang.reflect.ParameterizedType;

import lombok.Getter;
import net.rvanasa.schoology.impl.SchoologyResponse;

/*
 * Represents a page of data with the size of entries and link to self, next, and previous page.
 * Additional requests are required by schoology page objects, so this class extends SchoologyReference
 */
@Getter
public abstract class SchoologyPage<T> extends SchoologyReference<T>
{
	
	int total;
	
	SchoologyLinks links;
	
	private Class<T> pageType;

	@SuppressWarnings("unchecked")
	public SchoologyPage()
	{
		this.pageType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	/**
	 * Is next page available?
	 * @return available
	 */
	public boolean hasNext()
	{
		return links.getNext() != null;
	}
	
	/**
	 * Attempt to get next page
	 * @return next page or null
	 */
	@SuppressWarnings("unchecked")
	public T next()
	{
		if(!hasNext()) return null;
		
		final String next = getLinks().getNext();
		final String resource = next.substring(next.lastIndexOf('/') + 1);
		
		SchoologyResponse response = schoology.get(resource).requireSuccess();
		
		return ((SchoologyReference<T>) schoology.getGson().fromJson(response.getBody().parse().asRawData(), pageType)).reference(schoology);
	}
	
	/**
	 * Is previous page available?
	 * @return available
	 */
	public boolean hasPrevious()
	{
		return links.getPrevious() != null;
	}
	
	/**
	 * Attempt to get previous page
	 * @return previous page or null
	 */
	@SuppressWarnings("unchecked")
	public T previous()
	{
		if(!hasPrevious()) return null;
		
		final String previous = getLinks().getPrevious();
		final String resource = previous.substring(previous.lastIndexOf('/') + 1);
		
		SchoologyResponse response = schoology.get(resource).requireSuccess();
		
		return ((SchoologyReference<T>) schoology.getGson().fromJson(response.getBody().parse().asRawData(), pageType)).reference(schoology);
	}
	
}
