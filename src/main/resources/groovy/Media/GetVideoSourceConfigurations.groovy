def cfg = context.getApplicationContext().getBean('videoSourceCfg');

response = new org.onvif.ver10.media.wsdl.GetVideoSourceConfigurationsResponse();										
response.getConfigurations().add(cfg);					
response;
