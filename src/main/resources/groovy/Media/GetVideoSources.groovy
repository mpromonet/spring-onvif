response = new org.onvif.ver10.media.wsdl.GetVideoSourcesResponse();

source = new org.onvif.ver10.schema.VideoSource()
source.setToken("videotoken");

response.getVideoSources().add(source);

response;
