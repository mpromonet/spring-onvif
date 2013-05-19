// unmarshall request
// =================
def soapMessage = request.getBody().getBody().get(0);
def jaxbCtx = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.media.wsdl");
def unmarshaller = jaxbCtx.createUnmarshaller();
def req = (org.onvif.ver10.media.wsdl.GetVideoEncoderConfigurationOptions) unmarshaller.unmarshal(soapMessage);
println "==> configuration:" + req.getConfigurationToken()  + " profile:"+ req.getProfileToken()

frameRateRange = new org.onvif.ver10.schema.IntRange();
frameRateRange.setMin(1);
frameRateRange.setMax(25);

qualityRange = new org.onvif.ver10.schema.IntRange();
qualityRange.setMin(1);
qualityRange.setMax(25);

h264Opts = new org.onvif.ver10.schema.H264Options();
h264Opts.setFrameRateRange(frameRateRange);

options = new org.onvif.ver10.schema.VideoEncoderConfigurationOptions();
options.setH264(h264Opts);
options.setQualityRange(qualityRange);

response = new org.onvif.ver10.media.wsdl.GetVideoEncoderConfigurationOptionsResponse();
response.setOptions(options);
response;