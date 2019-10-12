package net.rvanasa.schoology.obj;

import lombok.Getter;

/*
 * Link provided to self
 * Useful for making additional requests to the given endpoint
 */
@Getter
public class SchoologyLinks
{
	
	String self;
	//Optional URL if next is available
	String next;
	//Optional URL if previous is available
	String previous;
	
}
