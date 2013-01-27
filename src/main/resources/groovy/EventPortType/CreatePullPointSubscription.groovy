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

def currentdate = new java.util.GregorianCalendar();
def xmlDate = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(currentdate.get(java.util.Calendar.YEAR),
																		currentdate.get(java.util.Calendar.MONTH) + 1,
																		currentdate.get(java.util.Calendar.DAY_OF_MONTH),
																		currentdate.get(java.util.Calendar.HOUR_OF_DAY),
																		currentdate.get(java.util.Calendar.MINUTE),
																		currentdate.get(java.util.Calendar.SECOND),
																		currentdate.get(java.util.Calendar.MILLISECOND), 0);

response = new org.onvif.ver10.events.wsdl.CreatePullPointSubscriptionResponse();
response.setSubscriptionReference(refbuilder.build());
response.setCurrentTime(xmlDate);

response;
