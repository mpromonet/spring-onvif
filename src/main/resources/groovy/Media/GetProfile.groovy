// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.media.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.onvif.ver10.media.wsdl.GetProfile) unmarshaller.unmarshal(soapMessage);
println "==> " + req.getProfileToken() 

response = new org.onvif.ver10.media.wsdl.GetProfileResponse();

def template = context.createProducerTemplate();
def profileList=template.requestBody("direct:getProfile",null);

profileList.each( 
		{ 
			if (req.getProfileToken() == it.getToken())
			{
				response.setProfile(it);
			}
		} 
	);

response;
