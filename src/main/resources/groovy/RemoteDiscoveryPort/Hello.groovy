// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.xmlsoap.schemas.ws._2005._04.discovery");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.xmlsoap.schemas.ws._2005._04.discovery.HelloType) unmarshaller.unmarshal(soapMessage);


// Query Discovery
// ----------------------------
helloMsg = new org.apache.cxf.ws.discovery.wsdl.HelloType();

client = new org.apache.cxf.ws.discovery.WSDiscoveryClient();
def probeMatches = client.register(helloMsg);
client.close();


// answer
// -------------
def rep = new org.xmlsoap.schemas.ws._2005._04.discovery.ResolveType()

rep;