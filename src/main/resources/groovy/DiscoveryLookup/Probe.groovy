response = new org.xmlsoap.schemas.ws._2005._04.discovery.ProbeMatchesType()


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

// Convert 
// ----------------------------
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