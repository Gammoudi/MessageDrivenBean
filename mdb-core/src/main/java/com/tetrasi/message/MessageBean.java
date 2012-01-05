package com.tetrasi.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "/queue/queueMessage")
		
},mappedName="/queue/queueMessage")
public class MessageBean implements MessageListener {

	public MessageBean() {
		super();
		
	}

	public void onMessage(Message message) {
		TextMessage textMessage=(TextMessage) message;
try {
	System.out.println(textMessage.getText());
} catch (JMSException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
