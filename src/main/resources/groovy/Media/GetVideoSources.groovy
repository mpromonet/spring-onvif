response = new org.onvif.ver10.media.wsdl.GetVideoSourcesResponse();

response.getVideoSources().add(context.getApplicationContext().getBean('videoSource1'));
response.getVideoSources().add(context.getApplicationContext().getBean('videoSource2'));

response;
