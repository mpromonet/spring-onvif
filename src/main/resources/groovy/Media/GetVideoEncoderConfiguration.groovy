def cfg = context.getApplicationContext().getBean('videoEncoderCfg');

response = new org.onvif.ver10.media.wsdl.GetVideoEncoderConfigurationResponse();
response.setConfiguration(cfg);
response;