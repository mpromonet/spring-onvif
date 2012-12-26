def response = new org.onvif.ver10.device.wsdl.GetScopesResponse();

def scope = new org.onvif.ver10.schema.Scope();
scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
scope.setScopeItem("onvif://www.onvif.org/name/" + properties.resolve("deviceid.name"))
response.getScopes().add(scope);

scope = new org.onvif.ver10.schema.Scope();
scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
scope.setScopeItem("onvif://www.onvif.org/location/" + properties.resolve("deviceid.location"))
response.getScopes().add(scope);

scope = new org.onvif.ver10.schema.Scope();
scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
scope.setScopeItem("onvif://www.onvif.org/hardware/" + properties.resolve("deviceid.hardware"))
response.getScopes().add(scope);

scope = new org.onvif.ver10.schema.Scope();
scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
scope.setScopeItem("onvif://www.onvif.org/Profile/" + properties.resolve("deviceid.profile"))
response.getScopes().add(scope);

if (properties.resolve("service.ptz.enabled") != "0")
{
	scope = new org.onvif.ver10.schema.Scope();
	scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
	scope.setScopeItem("onvif://www.onvif.org/type/ptz")
	response.getScopes().add(scope);
}

if (properties.resolve("service.recording.enabled") != "0")
{
	scope = new org.onvif.ver10.schema.Scope();
	scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
	scope.setScopeItem("onvif://www.onvif.org/type/Network_Video_Storage")
	response.getScopes().add(scope);
}

if (properties.resolve("service.media.enabled") != "0")
{
	scope = new org.onvif.ver10.schema.Scope();
	scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
	scope.setScopeItem("onvif://www.onvif.org/type/Network_Video_Transmitter")
	response.getScopes().add(scope);
}

response;
