response = new org.onvif.ver10.device.wsdl.GetUsersResponse();

def template = context.createProducerTemplate();
def userList=template.requestBody("direct:getUserList","");

userList.each( 
		{ 
			println "==> User:" + it;
			response.getUser().add(it);

		} 
	);

println "==> nb users:" + response.getUser().size()

response;
