response = new org.onvif.ver10.events.wsdl.CreatePullPointSubscriptionResponse();

url = request.getHeader("CamelCxfMessage")["http.base.path"]+ "/webservices";

endpoint = new org.xmlsoap.schemas.ws._2004._08.addressing.EndpointReferenceType();					
endpoint.setAddress(url+"/PullPointSubscription");
response.setSubscriptionReference(endpoint);

response;
