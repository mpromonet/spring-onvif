def ptzfilter = new org.onvif.ver10.schema.PTZFilter();
def event = new org.onvif.ver10.schema.EventSubscription();

def metadata = new org.onvif.ver10.schema.MetadataConfiguration();
metadata.setPTZStatus(ptzfilter);
metadata.setEvents(event);
metadata.setAnalytics(false);

def response = new org.onvif.ver10.media.wsdl.GetCompatibleMetadataConfigurationsResponse();
response.getConfigurations().add(metadata);
response;
