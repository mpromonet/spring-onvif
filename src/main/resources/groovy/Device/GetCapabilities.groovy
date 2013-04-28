// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.device.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.onvif.ver10.device.wsdl.GetCapabilities) unmarshaller.unmarshal(soapMessage);

req.getCategory().each( { println "==> Category:" + it } );

// prepare answer
// =================
def url = request.getHeader("CamelCxfMessage")["http.base.path"]+ "/webservices";

def rep = new org.onvif.ver10.device.wsdl.GetCapabilitiesResponse();
def capabilities =  new org.onvif.ver10.schema.Capabilities();
def extendCapability = new org.onvif.ver10.schema.CapabilitiesExtension();


def deviceCapability = new org.onvif.ver10.schema.DeviceCapabilities();
deviceCapability.setXAddr(url+properties.resolve("device.address"));

def onvifversion = new org.onvif.ver10.schema.OnvifVersion();
onvifversion.setMajor(properties.resolve("onvif.major").toInteger() );
onvifversion.setMinor(properties.resolve("onvif.minor").toInteger());

def systemCapability = new org.onvif.ver10.schema.SystemCapabilities();
systemCapability.getSupportedVersions().add(onvifversion);
deviceCapability.setSystem(systemCapability);

def networkCapability = new org.onvif.ver10.schema.NetworkCapabilities();
deviceCapability.setNetwork(networkCapability);
capabilities.setDevice(deviceCapability);

if (properties.resolve("service.deviceio.enabled") != "0")
{
	def deviceIOCapability = new org.onvif.ver10.schema.DeviceIOCapabilities();
	deviceIOCapability.setXAddr(url+"/DeviceIO");
	extendCapability.setDeviceIO(deviceIOCapability);
}

if (properties.resolve("service.event.enabled") != "0")
{
	def eventCapability = new org.onvif.ver10.schema.EventCapabilities();
	eventCapability.setXAddr(url+"/EventPortType");
	eventCapability.setWSPullPointSupport(true);
	eventCapability.setWSSubscriptionPolicySupport(true);
	capabilities.setEvents(eventCapability);
}

if (properties.resolve("service.media.enabled") != "0")
{
	def streamingCapability = new org.onvif.ver10.schema.RealTimeStreamingCapabilities();
	streamingCapability.setRTPMulticast(false);
	streamingCapability.setRTPTCP(true);
	streamingCapability.setRTPRTSPTCP(true);
	
	def mediaCapability = new org.onvif.ver10.schema.MediaCapabilities();
	mediaCapability.setXAddr(url+"/Media");
	mediaCapability.setStreamingCapabilities(streamingCapability);
	
	capabilities.setMedia(mediaCapability);
}

if (properties.resolve("service.ptz.enabled") != "0")
{
	def ptzCapability = new org.onvif.ver10.schema.PTZCapabilities();
	ptzCapability.setXAddr(url+"/PTZ");
	capabilities.setPTZ(ptzCapability);
}

if (properties.resolve("service.replay.enabled") != "0")
{
	def replayCapability = new org.onvif.ver10.schema.ReplayCapabilities();
	replayCapability.setXAddr(url+"/Replay");
	extendCapability.setReplay(replayCapability);
}

if (properties.resolve("service.recording.enabled") != "0")
{
	def recordCapability = new org.onvif.ver10.schema.RecordingCapabilities();
	recordCapability.setXAddr(url+"/Recording");
	extendCapability.setRecording(recordCapability);	
}
					
capabilities.setExtension(extendCapability);					
rep.setCapabilities(capabilities);

rep;