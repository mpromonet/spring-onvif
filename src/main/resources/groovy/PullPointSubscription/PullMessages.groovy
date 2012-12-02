def rep = new org.onvif.ver10.events.wsdl.PullMessagesResponse();

for ( i in 0..9 ) 
{
	def elt = new javax.xml.bind.JAXBElement<String>(new javax.xml.namespace.QName("ns","name"),String.class, "message" + i);

	def message = new org.oasis_open.docs.wsn.b_2.NotificationMessageHolderType.Message();
	message.setAny(elt);

	def notification = new org.oasis_open.docs.wsn.b_2.NotificationMessageHolderType();
	notification.setMessage(message);

	rep.getNotificationMessage().add(notification);
}

rep;
