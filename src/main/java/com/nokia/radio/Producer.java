/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.nokia.radio;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息生产者
 * 
 * @author <a href="laixiaoxuan@gmail.com">Adrian LAI</a>
 *
 */
public class Producer extends Thread 
{
    /**
	 * slf4j logger interface
	 */
	protected static final transient Logger LOG = LoggerFactory.getLogger(Producer.class);
	 /**
	 * Amq service url
	 */
	private String url;
	 /**
	 * Amq queue
	 */
	private String subject;
	 /**
	 * Message
	 */
	private String msg;

	public Producer(String url,String subject,String msg) 
	{
		super();
		this.url = url;
		this.subject=subject;
		this.msg=msg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() 
	{
		Connection connection = null;
		Session session = null;
		MessageProducer producer =null;
		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(subject);
			producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			TextMessage message = session.createTextMessage(msg);
			producer.send(message);
			LOG.info(message.getText());
		} catch (Exception e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				producer.close();
			} catch (Throwable ignore) {
			}
			try {
				session.close();
			} catch (Throwable ignore) {
			}
			try {
				connection.close();
			} catch (Throwable ignore) {
			}
		}
	}
}
