def rep = new org.onvif.ver10.events.wsdl.PullMessagesResponse();

for ( i in 0..9 ) 
{
	def item = new org.onvif.ver10.schema.ItemList.SimpleItem();
	item.setName("content");
	item.setValue( "message" + i);
	
	def itemList = new org.onvif.ver10.schema.ItemList();
	itemList.getSimpleItem().add(item);
	
	def msg = new org.onvif.ver10.schema.Message();
	msg.setData(itemList);
	
	def domResult = new javax.xml.transform.dom.DOMResult();
	def marshaller = javax.xml.bind.JAXBContext.newInstance("org.onvif.ver10.schema").createMarshaller();
	marshaller.marshal(msg,domResult);

	def message = new org.oasis_open.docs.wsn.b_2.NotificationMessageHolderType.Message();
	message.setAny(domResult.getNode().getDocumentElement());

	def notification = new org.oasis_open.docs.wsn.b_2.NotificationMessageHolderType();
	notification.setMessage(message);

	rep.getNotificationMessage().add(notification);
}

rep;
