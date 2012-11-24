frameRateRange = new org.onvif.ver10.schema.IntRange();
frameRateRange.setMin(1);
frameRateRange.setMax(25);

h264Opts = new org.onvif.ver10.schema.H264Options();
h264Opts.setFrameRateRange(frameRateRange);

options = new org.onvif.ver10.schema.VideoEncoderConfigurationOptions();
options.setH264(h264Opts);

response = new org.onvif.ver10.media.wsdl.GetVideoEncoderConfigurationOptionsResponse();
response.setOptions(options);
response;