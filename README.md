# schoology-api
Java API and implementation for Schoology (http://schoology.com) 

If you just want a simple way to use two-legged authentication with Schoology, here you go. 

Make sure to use the `schoology-oauth` module for the actual OAuth implementation. 
 
Example usage:

~~~~
// import net.rvanasa.schoology.SchoologyRequestHandler;
// import net.rvanasa.schoology.impl.BasicOAuthResourceLocator;
// import net.rvanasa.schoology.impl.OAuthSchoologyRequestHandler;

SchoologyRequestHandler schoology = new OAuthSchoologyRequestHandler(new BasicOAuthResourceLocator(DISTRICT_PREFIX), API_KEY, API_SECRET);

String json = schoology.get("sections/123456789").requireSuccess().getBody().getRawData();
System.out.println(json);

~~~~

You can generate and API key and secret by going to '[DISTRICT_PREFIX].schoology.com/api'

By the way, this is way more straightforward than Schoology's official PHP SDK and only supports two-legged OAuth. If you need any additional features, feel free to send me an email with some info regarding your potential use case. 
