def cfg = context.getApplicationContext().getBean('videoSourceCfg');

response = new org.onvif.ver10.media.wsdl.GetVideoSourceConfigurationResponse();					
response.setConfiguration(cfg);					
response;
