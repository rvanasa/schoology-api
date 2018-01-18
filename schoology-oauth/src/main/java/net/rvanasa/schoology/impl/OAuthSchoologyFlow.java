package net.rvanasa.schoology.impl;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import net.rvanasa.schoology.SchoologyContentType;
import net.rvanasa.schoology.SchoologyRequestHandler;
import net.rvanasa.schoology.SchoologyResponse;

public class OAuthSchoologyFlow implements SchoologyRequestHandler
{
	public static OAuthService createService(OAuthResourceLocator locator, String key, String secret)
	{
		return new ServiceBuilder()
				.provider(new OAuthSchoologyApi(locator))
				.apiKey(key)
				.apiSecret(secret)
				.signatureType(SignatureType.Header)
				.build();
	}
	
	private final OAuthResourceLocator resourceLocator;
	
	private final OAuthService service;
	
	private SchoologyContentType contentType = SchoologyContentTypeEnum.JSON;
	
	public OAuthSchoologyFlow(OAuthResourceLocator locator, String key, String secret)
	{
		this(locator, createService(locator, key, secret));
	}
	
	public OAuthSchoologyFlow(OAuthResourceLocator locator, OAuthService service)
	{
		this.resourceLocator = locator;
		this.service = service;
	}
	
	public OAuthResourceLocator getResourceLocator()
	{
		return resourceLocator;
	}
	
	public OAuthService getOAuthService()
	{
		return service;
	}
	
	public SchoologyContentType getContentType()
	{
		return contentType;
	}
	
	public void setContentType(SchoologyContentType contentType)
	{
		this.contentType = contentType;
	}
	
	public OAuthRequest prepareRequest(Verb verb, String resource)
	{
		OAuthRequest request = new OAuthRequest(Verb.GET, getResourceLocator().getRequestUrl(resource));
		getOAuthService().signRequest(Token.empty(), request);
		request.addHeader("Accept", getContentType().getID());
		
		return request;
	}
	
	public SchoologyResponse prepareResponse(Response response)
	{
		return new BasicSchoologyResponse(
				SchoologyResponseStatusEnum.getStatus(response.getCode()),
				new BasicSchoologyResponseBody(getContentType(), response.getBody()));
	}
	
	@Override
	public SchoologyResponse get(String resource)
	{
		OAuthRequest request = prepareRequest(Verb.GET, resource);
		Response response = request.send();
		
		return prepareResponse(response);
	}
	
	@Override
	public SchoologyResponse multiget(String... resources)
	{
		String payload = "<?xml version='1.0' encoding='utf-8'?><requests>";
		for(String resource : resources)
		{
			payload += "<request>/v1/" + resource + "</request>";
		}
		payload += "</requests>";
		
		OAuthRequest request = prepareRequest(Verb.POST, "multiget");
		request.addHeader("Content-Type", "text/xml");
		request.addPayload(payload);
		
		Response response = request.send();
		
		return prepareResponse(response);
	}
	
	@Override
	public SchoologyResponse post(String resource, String body)
	{
		OAuthRequest request = prepareRequest(Verb.POST, resource);
		request.addPayload(body);
		
		Response response = request.send();
		
		return prepareResponse(response);
	}
	
	@Override
	public SchoologyResponse options(String resource)
	{
		OAuthRequest request = prepareRequest(Verb.OPTIONS, resource);
		Response response = request.send();
		
		return prepareResponse(response);
	}
}
