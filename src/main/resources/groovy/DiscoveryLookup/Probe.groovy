// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
println soapMessage
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.network.wsdl");
def probe = jaxbCtx.createUnmarshaller().unmarshal(soapMessage).getValue();

probe.getTypes().each( { println "==> Type:" + it } );
probe.getScopes().each( { println "==> Scope:" + it } );
probe.getAny().each( { println "==> Any:" + it } );
probe.getOtherAttributes().each( { println "==> Other:" + it } );


println "=========================";
jaxbCtx.createMarshaller().marshal(new javax.xml.bind.JAXBElement(new javax.xml.namespace.QName("http://www.onvif.org/ver10/network/wsdl","Probe"), probe.class, probe),System.out)
println "";

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
		println "Endpoints:" + item.getEndpointReference() 
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
		rep.getProbeMatch().add(responseItem); 
	} );

// Print Response
// ----------------------------
rep.getProbeMatch().each( { item -> 
		println "XAddrs:" +item.getXAddrs(); 
		println "Endpoints:" + item.getEndpointReference().getAddress().getValue();
	} );

println "=========================";
jaxbCtx.createMarshaller().marshal(new javax.xml.bind.JAXBElement(new javax.xml.namespace.QName("http://www.onvif.org/ver10/network/wsdl","ProbeResponse"), rep.class, rep),System.out)
println "";

println rep	
rep