def ptzCfg = context.getApplicationContext().getBean('ptzCfg');

response = new org.onvif.ver20.ptz.wsdl.GetConfigurationsResponse();
response.getPTZConfiguration().add(ptzCfg);
response;
