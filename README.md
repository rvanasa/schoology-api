# schoology-api
Java API and implementation for Schoology (http://schoology.com) 

If you just want a simple way to use two-legged authentication with Schoology, here you go. 

Make sure to use the `schoology-oauth` module for the actual OAuth implementation. 
 
Example usage:

~~~~java

SchoologyRequestHandler schoology = new OAuthSchoologyRequestHandler(new BasicOAuthResourceLocator(DISTRICT_PREFIX), API_KEY, API_SECRET);


SchoologyResponseBody response = schoology.get("sections/123456789").requireSuccess().getBody();

System.out.println(response.getRawData()); // JSON string

SchoologyNode node = response.parse();
System.out.println(node.get("JSON_KEY").get(1).asString()); // index 1 of some JSON_KEY property

~~~~

You can generate and API key and secret by going to '[DISTRICT_PREFIX].schoology.com/api'

By the way, this is way more straightforward than Schoology's official PHP SDK and only supports two-legged OAuth. If you need any additional features, feel free to send me an email with some info regarding your potential use case. 
