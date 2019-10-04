package net.rvanasa.schoology.obj;

import lombok.Getter;

/*
 * Represents a page of data with the size of entries and link to self & next page
 */
@Getter
public abstract class SchoologyPage
{
	
	int total;
	
	SchoologyLinks links;
	
}
