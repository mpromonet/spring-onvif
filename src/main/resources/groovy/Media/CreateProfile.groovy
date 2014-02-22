// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.media.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.onvif.ver10.media.wsdl.CreateProfile) unmarshaller.unmarshal(soapMessage);

// answer
// ====
response = new org.onvif.ver10.media.wsdl.CreateProfileResponse();

println "==> profile name:" + req.getName() + " token:" + req.getToken();

def profile = new org.onvif.ver10.schema.Profile();
profile.setName(req.getName());
profile.setToken(req.getToken());

def template = context.createProducerTemplate();
template.requestBody("direct:addProfile",profile);

response.setProfile(profile);

response;
