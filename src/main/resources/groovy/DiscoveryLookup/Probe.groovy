client = new org.apache.cxf.ws.discovery.WSDiscoveryClient();
client.setDefaultProbeTimeout(1000);

probeType = new org.apache.cxf.ws.discovery.wsdl.ProbeType();
response = client.probe(probeType);
					
response;
