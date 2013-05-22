// SOAP headers
// =================
request.getBody().getHeaders().each( { println "==> SOAP Header: {" + it.getObject().getNamespaceURI()+ "}:"+ it.getObject().getLocalName()  + "=" + it.getObject().getTextContent() } );

pullpoint = context.getApplicationContext().getBean("CxfPullPointSubscription");
def url = request.getHeader("CamelCxfMessage")["http.base.path"]+ "/webservices";

def s = "<SubscriptionId>"+request.getHeader("CamelCxfMessage")+"</SubscriptionId>";
def stringbuffer = new java.io.StringBufferInputStream(s);
def docbuiler = javax.xml.parsers.DocumentBuilderFactory.newInstance();
def db = docbuiler.newDocumentBuilder();
def doc = db.parse(stringbuffer);

def refbuilder = new javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder();
refbuilder.address(url+pullpoint.getAddress());
refbuilder.serviceName(pullpoint.getServiceName());
refbuilder.wsdlDocumentLocation(pullpoint.getWsdlURL());
refbuilder.referenceParameter(doc.getDocumentElement());

def currentdate = new java.util.GregorianCalendar();
def currentXmlDate = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(currentdate.get(java.util.Calendar.YEAR),
																		currentdate.get(java.util.Calendar.MONTH) + 1,
																		currentdate.get(java.util.Calendar.DAY_OF_MONTH),
																		currentdate.get(java.util.Calendar.HOUR_OF_DAY),
																		currentdate.get(java.util.Calendar.MINUTE),
																		currentdate.get(java.util.Calendar.SECOND),
																		currentdate.get(java.util.Calendar.MILLISECOND), 0);

currentdate.add(java.util.Calendar.MINUTE,10);
def terminaisonXmlDate = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(currentdate.get(java.util.Calendar.YEAR),
																		currentdate.get(java.util.Calendar.MONTH) + 1,
																		currentdate.get(java.util.Calendar.DAY_OF_MONTH),
																		currentdate.get(java.util.Calendar.HOUR_OF_DAY),
																		currentdate.get(java.util.Calendar.MINUTE),
																		currentdate.get(java.util.Calendar.SECOND),
																		currentdate.get(java.util.Calendar.MILLISECOND), 0);

response = new org.onvif.ver10.events.wsdl.CreatePullPointSubscriptionResponse();
response.setSubscriptionReference(refbuilder.build());
response.setCurrentTime(currentXmlDate);
response.setTerminationTime(terminaisonXmlDate);

response;
