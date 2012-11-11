response = new org.onvif.ver10.device.wsdl.GetHostnameResponse();

host = new org.onvif.ver10.schema.HostnameInformation();
host.setName(java.net.InetAddress.getLocalHost().getHostName());
response.setHostnameInformation(host);

response;
