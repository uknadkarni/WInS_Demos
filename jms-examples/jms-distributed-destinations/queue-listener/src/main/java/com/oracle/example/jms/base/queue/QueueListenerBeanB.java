package com.oracle.example.jms.base.queue;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

/**
 * **************************************************************************
 * <p/>
 * This code is provided for example purposes only.  Oracle does not assume
 * any responsibility or liability for the consequences of using this code.
 * If you choose to use this code for any reason, including but not limited
 * to its use as an example you do so at your own risk and without the support
 * of Oracle.
 * <p/>
 * *****************************************************************************
 * User: jeffrey.a.west
 * Date: Jan 17, 2011
 * Time: 12:50:42 PM
 */

@MessageDriven(
    messageListenerInterface = javax.jms.MessageListener.class,
    name = "QueueListenerBMDB",
    mappedName = "com/oracle/example/jms/base/queue",
    activationConfig = {
        @ActivationConfigProperty(
            propertyName = "connectionFactoryJndiName",
            propertyValue = "com/oracle/example/jms/base/cf"),
        @ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "javax.jms.Queue")
    })


public class QueueListenerBeanB
    implements MessageListener
{

  public static final boolean DEBUG = false;

  public QueueListenerBeanB()
  {
  }

  public void onMessage(Message message)
  {
    if (DEBUG)
    {
      StringWriter stringWriter = new StringWriter();
      PrintWriter writer = new PrintWriter(stringWriter);

      try
      {
        writer.println("===================================================");
        writer.println("MDB class=[" + this.getClass().getName() + "]");
        writer.println("");
        writer.println("JMS Message Id: " + message.getJMSMessageID());

        for (Enumeration em = message.getPropertyNames(); em.hasMoreElements(); )
        {
          String property = (String) em.nextElement();
          writer.println("JMS Prop=[" + property + "] value=[" + message.getStringProperty(property) + "]");
        }

        writer.println("===================================================");
      }
      catch (JMSException e)
      {
        e.printStackTrace(writer);
      }

      writer.flush();
      System.out.println(stringWriter.toString());
    }

    if (message instanceof TextMessage)
    {
      TextMessage msg = (TextMessage) message;

      try
      {
        System.out.println("B - Queue Message:" + msg.getText());
      }
      catch (JMSException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      //DEMO is expecting text messages
    }


    try
    {
      Thread.sleep(1500);
    }
    catch (Exception ignore)
    {
    }
  }
}
