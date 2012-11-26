package com.oracle.demo.ops.event.consumer;

import com.oracle.demo.ops.Constants;
import com.oracle.demo.ops.domain.ParcelEvent;
import com.oracle.demo.ops.domain.ParcelStatus;
import com.oracle.demo.ops.domain.Shipment;
import com.oracle.demo.ops.string.StringUtils;
import com.oracle.demo.ops.xml.MyMarshaller;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyawest
 * Date: 8/2/12
 * Time: 4:46 PM
 */
public class OPSEventConsumer
{
  private InitialContext context;

  ConnectionFactory jmsConnectionFactory;
  Destination jmsDestination;
  Connection conn;
  Session session;
  MessageConsumer messageConsumer;

  static final String JMS_ENDPOINT = "t3://127.0.0.1:7101,127.0.0.1:7102";

  public static void main(String[] args)
  {
    try
    {
      int theID = (int) System.currentTimeMillis();

      OPSEventConsumer eventConsumer = new OPSEventConsumer(
          JMS_ENDPOINT,
          "weblogic",
          "welcome1",
          Constants.CONNECTION_FACTORY_JNDI,
          Constants.EVENT_QUEUE_JNDI);

      while (true)
      {
        String event = eventConsumer.consumeEvent();
        System.out.println("Received Event: " + event);
        Thread.sleep(1000);
      }
    }
    catch (NamingException e)
    {
      e.printStackTrace();
    }
    catch (JMSException e)
    {
      e.printStackTrace();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
  }

  private String consumeEvent() throws JMSException
  {
    // you can user receive, receiveNoWait or receive(timeout)
    Message message = messageConsumer.receiveNoWait();

    if (message != null)
    {
      if (message instanceof TextMessage)
      {
        String text = ((TextMessage) message).getText();
        return text;
      }
      else
      {
        System.out.println("Unexpected message type: " + message.getClass());
      }
    }
    else
    {
      System.out.println("Null Message");
    }

    return null;
  }


  public OPSEventConsumer(final String pURL,
                          final String pUsername,
                          final String pPassword,
                          final String connectionFactoryName,
                          final String destinationJNDI)
      throws NamingException
  {
    Hashtable<String, String> h = new Hashtable<String, String>(7);
    h.put(Context.INITIAL_CONTEXT_FACTORY, Constants.WL_INITIAL_CONTEXT);
    h.put(Context.PROVIDER_URL, pURL);
    h.put(Context.SECURITY_PRINCIPAL, pUsername);
    h.put(Context.SECURITY_CREDENTIALS, pPassword);

    context = new InitialContext(h);
    jmsConnectionFactory = (ConnectionFactory) context.lookup(connectionFactoryName);
    jmsDestination = (Destination) context.lookup(destinationJNDI);

    try
    {
      conn = jmsConnectionFactory.createConnection();
      session = conn.createSession(true, 1);
      messageConsumer = session.createConsumer(jmsDestination);
    }
    catch (JMSException e)
    {
      e.printStackTrace();
    }
  }

}
