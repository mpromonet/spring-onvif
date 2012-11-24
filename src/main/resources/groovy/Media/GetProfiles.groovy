def profile = context.getApplicationContext().getBean('profile');

response = new org.onvif.ver10.media.wsdl.GetProfilesResponse();
response.getProfiles().add(profile);
response;
