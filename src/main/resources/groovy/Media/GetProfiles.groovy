response = new org.onvif.ver10.media.wsdl.GetProfilesResponse();

def template = context.createProducerTemplate();
def profileList=template.requestBody("direct:getProfile",null);
profileList.each( 
		{ 
			println "==> Profile:" + it;
			response.getProfiles().add(it);
		} 
	);

println "==> nb profiles:" + response.getProfiles().size()

response;
