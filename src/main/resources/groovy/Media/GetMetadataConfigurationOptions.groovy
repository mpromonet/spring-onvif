// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.media.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.onvif.ver10.media.wsdl.GetMetadataConfigurationOptions) unmarshaller.unmarshal(soapMessage);
println "==> configuration:" + req.getConfigurationToken()  + " profile:"+ req.getProfileToken()

response = new org.onvif.ver10.media.wsdl.GetMetadataConfigurationOptionsResponse();
response;