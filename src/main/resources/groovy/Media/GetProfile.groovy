// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.media.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.onvif.ver10.media.wsdl.GetProfile) unmarshaller.unmarshal(soapMessage);
println "==> " + req.getProfileToken() 

response = new org.onvif.ver10.media.wsdl.GetProfileResponse();

if (req.getProfileToken() == "profile")
{
	def profile =  context.getApplicationContext().getBean('profile');
	response.setProfile(profile);
}

response;
