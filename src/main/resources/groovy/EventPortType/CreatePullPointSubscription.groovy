println "======================================="  + request

pullpoint = context.getApplicationContext().getBean("CxfPullPointSubscription");
println "==============" +  pullpoint;
println "==============" +  pullpoint.getAddress();
println "==============" +  pullpoint.getServiceName();
println "==============" +  pullpoint.getWsdlURL();

def url = request.getHeader("CamelCxfMessage")["http.base.path"]+ "/webservices";

def refbuilder = new javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder();
refbuilder.address(url+pullpoint.getAddress());
refbuilder.serviceName(pullpoint.getServiceName());
refbuilder.wsdlDocumentLocation(pullpoint.getWsdlURL());

response = new org.onvif.ver10.events.wsdl.CreatePullPointSubscriptionResponse();
response.setSubscriptionReference(refbuilder.build());
response;
