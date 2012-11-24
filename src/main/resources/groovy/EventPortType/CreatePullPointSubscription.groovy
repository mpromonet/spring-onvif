println "======================================="  + request

pullpoint = context.getApplicationContext().getBean("CxfPullPointSubscription");
println "==============" +  pullpoint;
println "==============" +  pullpoint.getProperties();
println "==============" +  pullpoint.getAddress();
println "==============" +  pullpoint.getBindingConfig();
println "==============" +  pullpoint.getPublishedEndpointUrl();
println "==============" +  pullpoint.getServiceClass().getName();
println "==============" +  pullpoint.getServiceName() ;
println "==============" +  pullpoint.getPortName() ;
println "==============" +  pullpoint.getPublishedEndpointUrl() ;
println "==============" +  pullpoint.getSchemaLocations() ;

java.lang.reflect.Method[] allMethods = pullpoint.getServiceClass().getDeclaredMethods();
allMethods.each( { println it.getName() } );

java.lang.reflect.Constructor[] allConstructors = pullpoint.getServiceClass().getDeclaredConstructors();
allConstructors.each( { println it.getName() } );

response = new org.onvif.ver10.events.wsdl.CreatePullPointSubscriptionResponse();
response.setSubscriptionReference(obj.getEndpointReference());
response;
