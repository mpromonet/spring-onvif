// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.device.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.onvif.ver10.device.wsdl.DeleteUsers) unmarshaller.unmarshal(soapMessage);

def template = context.createProducerTemplate();
req.getUsername().each( 
	{ 
		println "==> Username:" + it 
		template.requestBody("direct:delUser",it);
	} 
);

// answer
// ====
response = new org.onvif.ver10.device.wsdl.DeleteUsersResponse();