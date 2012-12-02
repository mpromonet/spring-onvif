def cfg = context.getApplicationContext().getBean('videoEncoderCfg');

response = new org.onvif.ver10.media.wsdl.GetVideoEncoderConfigurationsResponse();
response.getConfigurations().add(cfg);
response;