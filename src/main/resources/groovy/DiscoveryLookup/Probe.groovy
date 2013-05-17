// SOAP headers
// =================
request.getBody().getHeaders().each( { println "==> SOAP Header: {" + it.getObject().getNamespaceURI()+ "}:"+ it.getObject().getLocalName()  + "=" + it.getObject().getTextContent() } );

// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.network.wsdl");
def probe = jaxbCtx.createUnmarshaller().unmarshal(soapMessage).getValue();

probe.getTypes().each( { println "==> Type:" + it } );
probe.getScopes().each( { println "==> Scope:" + it } );
probe.getAny().each( { println "==> Any:" + it } );
probe.getOtherAttributes().each( { println "==> Other:" + it } );


// Query Discovery
// ----------------------------
client = new org.apache.cxf.ws.discovery.WSDiscoveryClient();
client.setDefaultProbeTimeout(1000);

probeType = new org.apache.cxf.ws.discovery.wsdl.ProbeType();
probe.getTypes().each( {probeType.getTypes().add(it); })
def probeMatches = client.probe(probeType);
client.close();

// Print Discovery Result
// ----------------------------
def matchesList = probeMatches.getProbeMatch();
matchesList.each( { item -> 
		println "========================"
		println "XAddrs:" +item.getXAddrs(); 
		println "Scopes:" + item.getScopes().getValue(); 
		println "Types:" + item.getTypes(); 
		println "Endpoints:(" + item.getEndpointReference().getClass() + ")" + item.getEndpointReference()
	} );

// Build Response
// ----------------------------
rep = new org.xmlsoap.schemas.ws._2005._04.discovery.ProbeMatchesType()

matchesList.each( { item ->  
		responseItem = new org.xmlsoap.schemas.ws._2005._04.discovery.ProbeMatchType() ; 
		item.getXAddrs().each ( { responseItem.getXAddrs().add(it); } );
		def endpoint = new org.xmlsoap.schemas.ws._2004._08.addressing.EndpointReferenceType();
		def address = new org.xmlsoap.schemas.ws._2004._08.addressing.AttributedURI();
		address.setValue("toto");
		endpoint.setAddress(address);
		responseItem.setEndpointReference(endpoint);
		def scope = new org.xmlsoap.schemas.ws._2005._04.discovery.ScopesType();
		item.getScopes().getValue().each ( { scope.getValue().add(it); } );		
		responseItem.setScopes(scope);
		rep.getProbeMatch().add(responseItem); 
	} );

// Print Response
// ----------------------------
rep.getProbeMatch().each( { item -> 
		println "=========================";
		println "XAddrs:" +item.getXAddrs(); 
		println "Scopes:" + item.getScopes().getValue();
		println "Endpoints:" + item.getEndpointReference().getAddress().getValue();
	} );

def result = new java.io.StringWriter();
def marshaller = jaxbCtx.createMarshaller();
marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, true);
marshaller.marshal(new javax.xml.bind.JAXBElement(new javax.xml.namespace.QName("http://www.onvif.org/ver10/network/wsdl","ProbeResponse"), rep.class, rep),result)
println "=========================";

result.toString();