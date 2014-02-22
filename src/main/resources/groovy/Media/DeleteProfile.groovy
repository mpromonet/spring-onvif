// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.media.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.onvif.ver10.media.wsdl.DeleteProfile) unmarshaller.unmarshal(soapMessage);

// answer
// ====
response = new org.onvif.ver10.media.wsdl.DeleteProfileResponse();

println "==> profile name:" + req.getProfileToken();

def template = context.createProducerTemplate();
template.requestBody("direct:delProfile",req.getProfileToken());

response;
