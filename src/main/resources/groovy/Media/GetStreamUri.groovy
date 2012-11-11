response = new org.onvif.ver10.media.wsdl.GetStreamUriResponse();

url = properties.resolve("media.streamuri.urlbase");
if (url =="")
{
	url = "rtsp://" + java.net.InetAddress.getLocalHost().getHostAddress();
}
url += properties.resolve("media.streamuri.urlsuffix");

uri = new org.onvif.ver10.schema.MediaUri();
uri.setUri(url);

response.setMediaUri(uri);
response;
