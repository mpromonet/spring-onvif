response = new org.onvif.ver10.device.wsdl.GetCapabilitiesResponse();
capabilities =  new org.onvif.ver10.schema.Capabilities();
extendCapability = new org.onvif.ver10.schema.CapabilitiesExtension();

url = request.getHeader("CamelCxfMessage")["http.base.path"]+ "/webservices";

deviceCapability = new org.onvif.ver10.schema.DeviceCapabilities();
deviceCapability.setXAddr(url+"/Device");
onvifversion = new org.onvif.ver10.schema.OnvifVersion();
onvifversion.setMajor(properties.resolve("onvif.major").toInteger() );
onvifversion.setMinor(properties.resolve("onvif.minor").toInteger());
systemCapability = new org.onvif.ver10.schema.SystemCapabilities();
systemCapability.getSupportedVersions().add(onvifversion);
deviceCapability.setSystem(systemCapability);
networkCapability = new org.onvif.ver10.schema.NetworkCapabilities();
deviceCapability.setNetwork(networkCapability);
capabilities.setDevice(deviceCapability);

if (properties.resolve("service.deviceio.enabled") != "0")
{
	deviceIOCapability = new org.onvif.ver10.schema.DeviceIOCapabilities();
	deviceIOCapability.setXAddr(url+"/DeviceIO");
	extendCapability.setDeviceIO(deviceIOCapability);
}

if (properties.resolve("service.event.enabled") != "0")
{
	eventCapability = new org.onvif.ver10.schema.EventCapabilities();
	eventCapability.setXAddr(url+"/EventPortType");
	eventCapability.setWSPullPointSupport(true);
	eventCapability.setWSSubscriptionPolicySupport(true);
	capabilities.setEvents(eventCapability);
}

if (properties.resolve("service.media.enabled") != "0")
{
	mediaCapability = new org.onvif.ver10.schema.MediaCapabilities();
	mediaCapability.setXAddr(url+"/Media");
	capabilities.setMedia(mediaCapability);
}

if (properties.resolve("service.ptz.enabled") != "0")
{
	ptzCapability = new org.onvif.ver10.schema.PTZCapabilities();
	ptzCapability.setXAddr(url+"/PTZ");
	capabilities.setPTZ(ptzCapability);
}

if (properties.resolve("service.replay.enabled") != "0")
{
	replayCapability = new org.onvif.ver10.schema.ReplayCapabilities();
	replayCapability.setXAddr(url+"/Replay");
	extendCapability.setReplay(replayCapability);
}

if (properties.resolve("service.recording.enabled") != "0")
{
	recordCapability = new org.onvif.ver10.schema.RecordingCapabilities();
	recordCapability.setXAddr(url+"/Recording");
	extendCapability.setRecording(recordCapability);	
}
					
capabilities.setExtension(extendCapability);					
response.setCapabilities(capabilities);

response;
