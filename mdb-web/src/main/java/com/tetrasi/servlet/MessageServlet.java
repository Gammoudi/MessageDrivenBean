package com.tetrasi.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: MyServlet
 *
 */
 public class MessageServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public MessageServlet() {
		super();
	}   	
	@Resource(mappedName="/queue/queueMessage")
	Queue queue;
	@Resource(mappedName="ConnectionFactory")
	QueueConnectionFactory connectionFactory;
	QueueSession sessionQueue;
	QueueConnection connection;
	TextMessage message;
	MessageProducer messageProducer;	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			InitialContext ctx=new InitialContext();
			queue=(Queue) ctx.lookup("queue/queueMessage");
			connectionFactory=(QueueConnectionFactory) ctx.lookup("/ConnectionFactory");
			connection=connectionFactory.createQueueConnection();
			sessionQueue=connection.createQueueSession(false, sessionQueue.AUTO_ACKNOWLEDGE);
			message=sessionQueue.createTextMessage();
			messageProducer=sessionQueue.createProducer(queue);
			Enumeration arr=request.getParameterNames();
			while(arr.hasMoreElements())
			{
			String fields= (String)arr.nextElement();
			String paramname[]=request.getParameterValues(fields);
			String s=null;
			int i;
			for (i=0; i<paramname.length;i++)
			{	
			s=fields+":" + paramname[i];
			message.setText(s);
			messageProducer.send(message);
			}
			}
			
			sessionQueue.close();
			connection.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}