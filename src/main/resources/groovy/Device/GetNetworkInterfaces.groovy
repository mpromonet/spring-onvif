response = new org.onvif.ver10.device.wsdl.GetNetworkInterfacesResponse();

def ip = java.net.InetAddress.getLocalHost(); 

linkLocal = new org.onvif.ver10.schema.PrefixedIPv4Address();
linkLocal.setAddress(ip.getHostAddress());
linkLocal.setPrefixLength(24);

ipv4Config = new org.onvif.ver10.schema.IPv4Configuration();
ipv4Config.setDHCP(false);
ipv4Config.getManual().add(linkLocal);

ipv4 = new org.onvif.ver10.schema.IPv4NetworkInterface();
ipv4.setEnabled(true);
ipv4.setConfig(ipv4Config);

def mac = java.net.NetworkInterface.getByInetAddress(ip).getHardwareAddress();
interfaceInfo = new org.onvif.ver10.schema.NetworkInterfaceInfo();
interfaceInfo.setHwAddress(mac.encodeHex().toString());

network = new org.onvif.ver10.schema.NetworkInterface();
network.setEnabled(true);
network.setIPv4(ipv4);				
network.setInfo(interfaceInfo);				
response.getNetworkInterfaces().add(network);

response;
