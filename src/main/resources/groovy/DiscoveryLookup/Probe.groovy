// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.network.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def _Probe_QNAME = new javax.xml.namespace.QName("http://www.onvif.org/ver10/network/wsdl", "Probe");
def jaxbMessage = unmarshaller.unmarshal(soapMessage);
def req = new javax.xml.bind.JAXBElement<org.xmlsoap.schemas.ws._2005._04.discovery.ProbeType>(_Probe_QNAME,jaxbMessage.getClass(),null,jaxbMessage.getValue());
def probeType = req.getValue();

probeType.getTypes().each( { println "==> Type:" + it } );
probeType.getScopes().each( { println "==> Scope:" + it } );
probeType.getAny().each( { println "==> Any:" + it } );

// Query Discovery
// ----------------------------
client = new org.apache.cxf.ws.discovery.WSDiscoveryClient();
client.setDefaultProbeTimeout(1000);

probeType = new org.apache.cxf.ws.discovery.wsdl.ProbeType();
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
response = new org.xmlsoap.schemas.ws._2005._04.discovery.ProbeMatchesType()

matchesList.each( { item ->  
		responseItem = new org.xmlsoap.schemas.ws._2005._04.discovery.ProbeMatchType() ; 
		item.getXAddrs().each ( { responseItem.getXAddrs().add(it); } );
		response.getProbeMatch().add(responseItem); 
	} );

response.getProbeMatch().each( { item -> 
		println "XAddrs:" +item.getXAddrs(); 
		println "Endpoints:" + item.getEndpointReference() 
	} );


response;