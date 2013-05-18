response = new org.onvif.ver10.media.wsdl.GetProfilesResponse();

def template = context.createProducerTemplate();
def profile=template.requestBody("direct:getProfile",null);
response.getProfiles().add(profile);

response;
