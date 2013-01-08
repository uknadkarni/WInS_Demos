package com.oracle.demo.ops.services.ejb;

import com.oracle.demo.ops.Constants;
import com.oracle.demo.ops.domain.Shipment;
import com.oracle.demo.ops.services.ShipmentJMSClient;
import com.oracle.demo.ops.xml.MyMarshaller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.*;
import javax.xml.bind.JAXBException;
import java.io.Serializable;

/**
 * **************************************************************************
 * <p/>
 * This code is provided for example purposes only.  Oracle does not assume
 * any responsibility or liability for the consequences of using this code.
 * If you choose to use this code for any reason, including but not limited
 * to its use as an example you do so at your own risk and without the support
 * of Oracle.
 * <p/>
 * ****************************************************************************
 * User: jeffrey.a.west
 * Date: 4/4/11
 * Time: 11:09 AM
 */
@Local(ShipmentJMSClient.class)
@Stateless(name="ShipmentJMSSenderBean", mappedName="ejb/ShipmentJMSSender")
public class ShipmentJMSClientImpl
    implements ShipmentJMSClient,
               Serializable
{
  @Resource(name = Constants.CONNECTION_FACTORY_JNDI, type = ConnectionFactory.class)
  private ConnectionFactory connectionFactory;

  @Resource(name = Constants.SHIPMENT_QUEUE_JNDI, type = Queue.class)
  private Queue queue;

  private Connection connection;
  private Session session;
  private MessageProducer producer;

  @PostConstruct
  public void initialize()
  {
    try
    {
      connection = connectionFactory.createConnection();
      session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      producer = session.createProducer(queue);
    }
    catch (JMSException e)
    {
      if (connection != null)
      {
        try
        {
          connection.close();
        }
        catch (JMSException f)
        {
          e.printStackTrace();
        }
      }
    }
  }

  @PreDestroy
  public void closeConnection()
  {
    try
    {
      if (connection != null)
      {
        connection.close();
      }
    }
    catch (JMSException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void publishShipment(Shipment shipment)
  {
    try
    {
      producer.send(session.createTextMessage(MyMarshaller.marshallObjectToString(shipment)));
    }
    catch (JMSException e)
    {
      e.printStackTrace();
    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }
  }
}