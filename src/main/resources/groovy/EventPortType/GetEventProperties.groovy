// SOAP headers
// =================
request.getBody().getHeaders().each( { println "==> SOAP Header: {" + it.getObject().getNamespaceURI()+ "}:"+ it.getObject().getLocalName()  + "=" + it.getObject().getTextContent() } );

def sourceDescription = new org.onvif.ver10.schema.ItemListDescription.SimpleItemDescription()
sourceDescription.setName("source");
sourceDescription.setType(new javax.xml.namespace.QName("{http://www.w3.org/2001/XMLSchema}string"));

def sourceDescriptionList = new org.onvif.ver10.schema.ItemListDescription();
sourceDescriptionList.getSimpleItemDescription().add(sourceDescription);

def dataDescription = new org.onvif.ver10.schema.ItemListDescription.SimpleItemDescription()
dataDescription.setName("data");
dataDescription.setType(new javax.xml.namespace.QName("{http://www.w3.org/2001/XMLSchema}string"));

def dataDescriptionList = new org.onvif.ver10.schema.ItemListDescription();
dataDescriptionList.getSimpleItemDescription().add(dataDescription);

def messageDecription = new org.onvif.ver10.schema.MessageDescription();
messageDecription.setSource(sourceDescriptionList);
messageDecription.setData(dataDescriptionList);

def domResult = new javax.xml.transform.dom.DOMResult();
def marshaller = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.schema").createMarshaller();
marshaller.marshal(new javax.xml.bind.JAXBElement(new javax.xml.namespace.QName("http://www.onvif.org/ver10/schema","MessageDescription"), messageDecription.class, messageDecription),domResult)

def topic = new org.oasis_open.docs.wsn.t_1.TopicSetType();
topic.getAny().add(domResult.getNode().getDocumentElement());

def response = new org.onvif.ver10.events.wsdl.GetEventPropertiesResponse();
response.setFixedTopicSet(false);
response.setTopicSet(topic);
response.getTopicExpressionDialect().add("http://docs.oasis-open.org/wsn/t-1/TopicExpression/Concrete");
response.getTopicExpressionDialect().add("http://www.onvif.org/ver10/tev/topicExpression/ConcreteSet");
response.getMessageContentFilterDialect().add("http://www.onvif.org/ver10/tev/messageContentFilter/ItemFilter");
response.getTopicNamespaceLocation().add("http://www.onvif.org/onvif/ver10/topics/topicns.xml");

response;
