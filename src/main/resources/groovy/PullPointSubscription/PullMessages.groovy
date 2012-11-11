elt = new javax.xml.bind.JAXBElement&lt;String&gt;(new javax.xml.namespace.QName("url","tag"),String.class, "message");

message = new org.oasis_open.docs.wsn.b_2.NotificationMessageHolderType.Message();
message.setAny(elt);

notification = new org.oasis_open.docs.wsn.b_2.NotificationMessageHolderType();
notification.setMessage(message);

response = new org.onvif.ver10.events.wsdl.PullMessagesResponse();
response.getNotificationMessage().add(notification);
response;
