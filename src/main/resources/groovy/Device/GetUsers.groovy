response = new org.onvif.ver10.device.wsdl.GetUsersResponse();

def template = context.createProducerTemplate();
def user=template.requestBody("direct:getAdminUser",null);

response.getUser().add(user);


response;
