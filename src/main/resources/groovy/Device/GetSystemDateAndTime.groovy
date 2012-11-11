currentdate = new java.util.GregorianCalendar();
date = new org.onvif.ver10.schema.Date();
date.setYear(currentdate.get(java.util.Calendar.YEAR));
date.setMonth(currentdate.get(java.util.Calendar.MONTH)+1);
date.setDay(currentdate.get(java.util.Calendar.DAY_OF_MONTH));
time = new org.onvif.ver10.schema.Time();
time.setHour(currentdate.get(java.util.Calendar.HOUR));
time.setMinute(currentdate.get(java.util.Calendar.MINUTE));
time.setSecond(currentdate.get(java.util.Calendar.SECOND));

dateTime = new org.onvif.ver10.schema.DateTime();
dateTime.setTime(time);
dateTime.setDate(date);

tz = new org.onvif.ver10.schema.TimeZone();
tz.setTZ("UTC");

systemDateTime = new org.onvif.ver10.schema.SystemDateTime ();
systemDateTime.setDateTimeType(org.onvif.ver10.schema.SetDateTimeType.MANUAL);
systemDateTime.setTimeZone(tz);
systemDateTime.setUTCDateTime(dateTime);

response = new org.onvif.ver10.device.wsdl.GetSystemDateAndTimeResponse();
response.setSystemDateAndTime(systemDateTime);
response;
