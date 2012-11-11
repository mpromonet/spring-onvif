response = new org.onvif.ver10.media.wsdl.GetSnapshotUriResponse();

uri = new org.onvif.ver10.schema.MediaUri();
url = properties.resolve("media.snapshoturi.urlbase");
if (url =="")
{
	url = request.getHeader("CamelCxfMessage")["http.base.path"];
}
url += properties.resolve("media.snapshoturi.urlsuffix");
uri.setUri(url);

response.setMediaUri(uri);
response;
