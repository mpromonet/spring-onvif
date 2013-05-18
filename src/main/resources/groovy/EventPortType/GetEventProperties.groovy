// SOAP headers
// =================
request.getBody().getHeaders().each( { println "==> SOAP Header: {" + it.getObject().getNamespaceURI()+ "}:"+ it.getObject().getLocalName()  + "=" + it.getObject().getTextContent() } );

topic = new org.oasis_open.docs.wsn.t_1.TopicSetType();

response = new org.onvif.ver10.events.wsdl.GetEventPropertiesResponse();
response.setFixedTopicSet(true);
response.setTopicSet(topic);
response.getTopicExpressionDialect().add("http://docs.oasis-open.org/wsn/t-1/TopicExpression/Concrete");
response.getTopicExpressionDialect().add("http://www.onvif.org/ver10/tev/topicExpression/ConcreteSet");
response.getMessageContentFilterDialect().add("http://www.onvif.org/ver10/tev/messageContentFilter/ItemFilter");

response;
