def response = new org.onvif.ver10.device.wsdl.GetScopesResponse();

def scope = new org.onvif.ver10.schema.Scope();
scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
scope.setScopeItem("onvif://www.onvif.org/name/" + properties.resolve("deviceid.name"))
response.getScopes().add(scope);

def scope = new org.onvif.ver10.schema.Scope();
scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
scope.setScopeItem("onvif://www.onvif.org/location/" + properties.resolve("deviceid.location"))
response.getScopes().add(scope);

def scope = new org.onvif.ver10.schema.Scope();
scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
scope.setScopeItem("onvif://www.onvif.org/hardware/" + properties.resolve("deviceid.hardware"))
response.getScopes().add(scope);

def scope = new org.onvif.ver10.schema.Scope();
scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
scope.setScopeItem("onvif://www.onvif.org/Profile/" + properties.resolve("deviceid.profile"))
response.getScopes().add(scope);

response;
