response = new org.onvif.ver20.ptz.wsdl.GetNodesResponse();

ptzSpace = new org.onvif.ver10.schema.PTZSpaces();
ptznode = new org.onvif.ver10.schema.PTZNode();
ptznode.setName("ptznode");
ptznode.setSupportedPTZSpaces(ptzSpace);
ptznode.setHomeSupported(true);
response.getPTZNode().add(ptznode);

response;
