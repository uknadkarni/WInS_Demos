package com.oracle.demo.ops.event.spring.listener.topic;

import com.oracle.demo.ops.domain.ParcelEvent;

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
 * Date: Feb 15, 2011
 * Time: 6:13:34 PM
 */
public class NotifyPackageDeliveredHandler
    extends AbstractEventHandler
{
  protected void handleEventInternal(ParcelEvent pEvent)
  {
    System.out.println("SPRING::NotifyPackageDelivered.handleEvent");
  }

}
