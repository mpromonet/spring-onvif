response = new org.onvif.ver10.device.wsdl.GetScopesResponse();

scope = new org.onvif.ver10.schema.Scope();
scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
scope.setScopeItem("onvif://www.onvif.org/name/" + properties.resolve("deviceid.name"))
response.getScopes().add(scope);

scope = new org.onvif.ver10.schema.Scope();
scope.setScopeDef(org.onvif.ver10.schema.ScopeDefinition.FIXED)
scope.setScopeItem("onvif://www.onvif.org/location/" + properties.resolve("deviceid.location"))
response.getScopes().add(scope);

response;
