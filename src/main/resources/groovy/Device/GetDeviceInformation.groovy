response = new org.onvif.ver10.device.wsdl.GetDeviceInformationResponse();

response.setManufacturer(properties.resolve("deviceid.manufacturer"));
response.setModel(properties.resolve("deviceid.model"));
response.setFirmwareVersion(properties.resolve("deviceid.firmware"));
response.setSerialNumber(properties.resolve("deviceid.serialnumber"));
response.setHardwareId(properties.resolve("deviceid.hardwareid"));

response;
