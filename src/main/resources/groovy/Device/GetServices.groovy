// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.device.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.onvif.ver10.device.wsdl.GetServices) unmarshaller.unmarshal(soapMessage);

println "==> isIncludeCapability:" + req.isIncludeCapability();

def url = request.getHeader("CamelCxfMessage")["http.base.path"]+ "/webservices";
def onvifversion = new org.onvif.ver10.schema.OnvifVersion();
onvifversion.setMajor(properties.resolve("onvif.major").toInteger() );
onvifversion.setMinor(properties.resolve("onvif.minor").toInteger());

def rep = new org.onvif.ver10.device.wsdl.GetServicesResponse();

def service = new org.onvif.ver10.device.wsdl.Service();
service.setNamespace("http://www.onvif.org/ver10/device/wsdl");
service.setXAddr(url+properties.resolve("device.address"));
service.setVersion(onvifversion);
rep.getService().add(service);

if (properties.resolve("service.deviceio.enabled") != "0")
{
	service = new org.onvif.ver10.device.wsdl.Service();
	service.setNamespace("http://www.onvif.org/ver10/deviceIO/wsdl");
	service.setXAddr(url+"/DeviceIO");
	service.setVersion(onvifversion);
	rep.getService().add(service);
}

if (properties.resolve("service.event.enabled") != "0")
{
	service = new org.onvif.ver10.device.wsdl.Service();
	service.setNamespace("http://www.onvif.org/ver10/events/wsdl");
	service.setXAddr(url+"/EventPortType");
	service.setVersion(onvifversion);
	rep.getService().add(service);
}

if (properties.resolve("service.media.enabled") != "0")
{
	service = new org.onvif.ver10.device.wsdl.Service();
	service.setNamespace("http://www.onvif.org/ver10/media/wsdl");
	service.setXAddr(url+"/Media");
	service.setVersion(onvifversion);
	rep.getService().add(service);
}

if (properties.resolve("service.ptz.enabled") != "0")
{
	service = new org.onvif.ver10.device.wsdl.Service();
	service.setNamespace("http://www.onvif.org/ver10/ptz/wsdl");
	service.setXAddr(url+"/PTZ");
	service.setVersion(onvifversion);
	rep.getService().add(service);
}

if (properties.resolve("service.replay.enabled") != "0")
{
	service = new org.onvif.ver10.device.wsdl.Service();
	service.setNamespace("http://www.onvif.org/ver10/replay/wsdl");
	service.setXAddr(url+"/Replay");
	service.setVersion(onvifversion);
	rep.getService().add(service);
}

if (properties.resolve("service.recording.enabled") != "0")
{
	service = new org.onvif.ver10.device.wsdl.Service();
	service.setNamespace("http://www.onvif.org/ver10/recording/wsdl");
	service.setXAddr(url+"/Recording");
	service.setVersion(onvifversion);
	rep.getService().add(service);
}
	

rep;