response = new org.onvif.ver10.device.wsdl.GetNetworkProtocolsResponse();

protocol = new org.onvif.ver10.schema.NetworkProtocol();
protocol.setName(org.onvif.ver10.schema.NetworkProtocolType.HTTP);
protocol.setEnabled(true);
protocol.getPort().add(9999);
response.getNetworkProtocols().add(protocol);

protocol = new org.onvif.ver10.schema.NetworkProtocol();
protocol.setName(org.onvif.ver10.schema.NetworkProtocolType.RTSP);
protocol.setEnabled(true);
protocol.getPort().add(9999);
response.getNetworkProtocols().add(protocol);

response;
