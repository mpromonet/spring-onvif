def videoEncoderCfg = context.getApplicationContext().getBean('videoEncoderCfg');

response = new org.onvif.ver10.media.wsdl.GetCompatibleVideoEncoderConfigurationsResponse();
response.getConfigurations().add(videoEncoderCfg);
response;
