// SOAP headers
// =================
request.getBody().getHeaders().each( { println "==> SOAP Header: {" + it.getObject().getNamespaceURI()+ "}:"+ it.getObject().getLocalName()  + "=" + it.getObject().getTextContent() } );

def messageDecription = new org.onvif.ver10.schema.MessageDescription();
def sourceDescriptionList = new org.onvif.ver10.schema.ItemListDescription();
def sourceDescription = new org.onvif.ver10.schema.ItemListDescription.SimpleItemDescription()
sourceDescription.setName("content");
sourceDescription.setType(new javax.xml.namespace.QName("{http://www.w3.org/2001/XMLSchema}string"));
sourceDescriptionList.getSimpleItemDescription().add(sourceDescription);
messageDecription.setSource(sourceDescriptionList);

def result = new java.io.StringWriter();
def marshaller = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.schema").createMarshaller();
marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, true);
marshaller.marshal(new javax.xml.bind.JAXBElement(new javax.xml.namespace.QName("http://www.onvif.org/ver10/schema","MessageDescription"), messageDecription.class, messageDecription),result)
println "===>" + result.toString() +"========================================";

def topic = new org.oasis_open.docs.wsn.t_1.TopicSetType();
//topic.getAny().add(messageDecription);

def response = new org.onvif.ver10.events.wsdl.GetEventPropertiesResponse();
response.setFixedTopicSet(false);
response.setTopicSet(topic);
response.getTopicExpressionDialect().add("http://docs.oasis-open.org/wsn/t-1/TopicExpression/Concrete");
response.getTopicExpressionDialect().add("http://www.onvif.org/ver10/tev/topicExpression/ConcreteSet");
response.getMessageContentFilterDialect().add("http://www.onvif.org/ver10/tev/messageContentFilter/ItemFilter");
response.getTopicNamespaceLocation().add("http://www.onvif.org/onvif/ver10/topics/topicns.xml");

response;
