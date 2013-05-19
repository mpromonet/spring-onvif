def response = new org.onvif.ver10.media.wsdl.GetCompatibleMetadataConfigurationsResponse();
response.getConfigurations().add(context.getApplicationContext().getBean('metadataCfg'));
response;
