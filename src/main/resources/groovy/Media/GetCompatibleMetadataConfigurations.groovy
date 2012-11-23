response = new org.onvif.ver10.media.wsdl.GetCompatibleMetadataConfigurationsResponse();
ptzfilter = org.onvif.ver10.schema.PTZFilter();
metadata = org.onvif.ver10.schema.MetadataConfiguration();
metadata.setPTZStatus(ptzfilter);
event = org.onvif.ver10.schema.EventSubscription();
metadata.setPTZStatus(ptzfilter);
response.getConfigurations().add(metadata);
response;
