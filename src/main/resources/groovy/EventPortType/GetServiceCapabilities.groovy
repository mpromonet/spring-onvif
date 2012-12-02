def capability = new org.onvif.ver10.events.wsdl.Capabilities();
capability.setWSPullPointSupport(true);
capability.setWSPausableSubscriptionManagerInterfaceSupport(false);

def rep = new org.onvif.ver10.events.wsdl.GetServiceCapabilitiesResponse();
rep.setCapabilities(capability);

rep;
