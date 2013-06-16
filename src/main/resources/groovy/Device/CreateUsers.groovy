// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.device.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.onvif.ver10.device.wsdl.CreateUsers) unmarshaller.unmarshal(soapMessage);

println "==> nb User:" + req.getUser().size();

def template = context.createProducerTemplate();
req.getUser().each( 
	{ 
		println "==> User:" + it 
		
		def schemaCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.schema");
		def result = new java.io.StringWriter();
		def marshaller = schemaCtx.createMarshaller();
		marshaller.marshal(new javax.xml.bind.JAXBElement(new javax.xml.namespace.QName("org.onvif.ver10.schema","User"), it.class, it),result);
		template.requestBodyAndHeader("direct:addUser",result.toString(),"username",it.getUsername());
	} 
);

// answer
// ====
response = new org.onvif.ver10.device.wsdl.CreateUsersResponse();