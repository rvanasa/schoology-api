# schoology-api
Java API and implementation for Schoology (https://schoology.com)

Behold, a straightforward two- and three-legged authentication wrapper for the Schoology REST API. 

Make sure to use the `schoology-oauth` module for the actual OAuth ([Scribe](https://github.com/scribejava/scribejava)) implementation. 
 
## Example Usage:

You can generate a user API key & secret by going to `https://{DISTRICT_PREFIX}.schoology.com/api`

### 2-Legged Auth:

```java

SchoologyRequestHandler schoology = new SchoologyRequestHandler(DISTRICT_PREFIX, API_KEY, API_SECRET);

```

### 3-Legged Auth:

```java

SchoologyFlow flow = new SchoologyFlow(DISTRICT_PREFIX, API_KEY, API_SECRET, CALLBACK_URL);

SchoologyToken token = flow.createRequestToken();

String authUrl = token.getAuthorizationUrl();

// redirect client...

String verifier = "[Response from callback URL]";

SchoologyRequestHandler schoology = token.createRequestHandler(verifier);

```

### Sending a Request:

Requests can be send and parsed manually, or by using the premade methods provided with the SchoologyRequestHandler.

#### Manually:
```java

// {UID} represents the target user ID
SchoologyResponseBody response = schoology.get("users/{UID}?extended=true").requireSuccess().getBody();

System.out.println(response.getRawData()); // raw JSON string

SchoologyNode node = response.parse();
System.out.println(node.get("name_display").asString()); // get display name of user

schoology.put("users/{UID}", "{\"name_first_preferred\": \"NewName\"}"); // set preferred first name

```

#### Using premade methods & objects:
```java

// {UID} represents the target user ID
SchoologyUser user = schoology.getUser("{UID}");

System.out.println(user.getNameDisplay()); // get display name of user

user.setNameFirstPreferred("NewName"); // set preferred first name

```

Big thanks to [@electro2560](https://github.com/electro2560) for taking this project to the next level. Contributions and feature requests are always welcome! 
