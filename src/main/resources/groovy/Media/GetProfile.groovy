def profile =  context.getApplicationContext().getBean('profile');

response = new org.onvif.ver10.media.wsdl.GetProfileResponse();
response.setProfile(profile);
response;
