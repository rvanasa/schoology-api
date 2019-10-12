package net.rvanasa.schoology;

import java.util.List;
import java.util.Map;

public interface SchoologyNode
{
	public SchoologyNode get(String key);
	
	public SchoologyNode get(int index);
	
	public boolean isNull();
	
	public boolean isEmpty();
	
	public boolean isContainer();
	
	public boolean isListValue();
	
	public boolean isMapValue();
	
	public List<SchoologyNode> asListValue();
	
	public Map<String, SchoologyNode> asMapValue();
	
	public String asRawData();
	
	public String asString();
	
	public boolean asBoolean();
	
	public Number asNumber();
	
	default int asInt()
	{
		return asNumber().intValue();
	}
	
	default byte asByte()
	{
		return asNumber().byteValue();
	}
	
	default short asShort()
	{
		return asNumber().shortValue();
	}
	
	default long asLong()
	{
		return asNumber().longValue();
	}
	
	default float asFloat()
	{
		return asNumber().floatValue();
	}
	
	default double asDouble()
	{
		return asNumber().doubleValue();
	}
}
