response = new org.onvif.ver10.device.wsdl.GetUsersResponse();

def template = context.createProducerTemplate();
def userList=template.requestBody("direct:getUserList","");

userList.each( 
		{ 
			println "==> User:" + it.get("MSG");
			def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.schema");
			def unmarshaller = jaxbCtx.createUnmarshaller();
			def xmlStr = new java.lang.StringBuffer( it.get("MSG") );
			def user = unmarshaller.unmarshal( new javax.xml.transform.stream.StreamSource( new java.io.StringReader( xmlStr.toString() ) ) ,  org.onvif.ver10.schema.User.class);						
			
			response.getUser().add((org.onvif.ver10.schema.User)user.getValue());

		} 
	);

println "==> nb users:" + response.getUser().size()

response;
