def rep = new org.onvif.ver10.events.wsdl.PullMessagesResponse();

for ( i in 0..9 ) 
{
	// build message
	//-----------------------
	def sourceItem = new org.onvif.ver10.schema.ItemList.SimpleItem();
	sourceItem.setName("source");
	sourceItem.setValue( "**************");
	
	def source = new org.onvif.ver10.schema.ItemList();
	source.getSimpleItem().add(sourceItem);

	def dataItem = new org.onvif.ver10.schema.ItemList.SimpleItem();
	dataItem.setName("data");
	dataItem.setValue( "message" + i);
	
	def data = new org.onvif.ver10.schema.ItemList();
	data.getSimpleItem().add(dataItem);

	def currentdate = new java.util.GregorianCalendar();
	def currentXmlDate = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(currentdate.get(java.util.Calendar.YEAR),
																			currentdate.get(java.util.Calendar.MONTH) + 1,
																			currentdate.get(java.util.Calendar.DAY_OF_MONTH),
																			currentdate.get(java.util.Calendar.HOUR_OF_DAY),
																			currentdate.get(java.util.Calendar.MINUTE),
																			currentdate.get(java.util.Calendar.SECOND),
																			currentdate.get(java.util.Calendar.MILLISECOND), 0);	

	def msg = new org.onvif.ver10.schema.Message();
	msg.setSource(source);
	msg.setData(data);
	msg.setUtcTime(currentXmlDate);
	
	// convert message to dom
	//----------------------------------------
	def domResult = new javax.xml.transform.dom.DOMResult();
	def marshaller = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.schema").createMarshaller();
	marshaller.marshal(msg,domResult);

	// append notification to the list
	//----------------------------------------
	def message = new org.oasis_open.docs.wsn.b_2.NotificationMessageHolderType.Message();
	message.setAny(domResult.getNode().getDocumentElement());

	def notification = new org.oasis_open.docs.wsn.b_2.NotificationMessageHolderType();
	notification.setMessage(message);

	rep.getNotificationMessage().add(notification);
}

rep;
