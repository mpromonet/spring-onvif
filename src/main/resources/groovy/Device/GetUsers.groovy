response = new org.onvif.ver10.device.wsdl.GetUsersResponse();

user = new org.onvif.ver10.schema.User();
user.setUsername("admin");
user.setUserLevel(org.onvif.ver10.schema.UserLevel.ADMINISTRATOR);
response.getUser().add(user);

response;
