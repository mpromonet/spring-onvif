response = new org.onvif.ver10.media.wsdl.GetVideoSourcesResponse();

source = new org.onvif.ver10.schema.VideoSource()
source.setToken("videotoken1");
response.getVideoSources().add(source);

source = new org.onvif.ver10.schema.VideoSource()
source.setToken("videotoken2");
response.getVideoSources().add(source);

response;
