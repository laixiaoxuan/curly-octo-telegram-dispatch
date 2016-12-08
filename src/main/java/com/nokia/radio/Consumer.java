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
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.nokia.radio.domain.Task;

/**
 * 消息消费者
 * 
 * @author <a href="laixiaoxuan@gmail.com">Adrian LAI</a>
 *
 */
public class Consumer extends Thread implements MessageListener, ExceptionListener 
{
    /**
	 * slf4j logger interface
	 */
	protected static final transient Logger LOG = LoggerFactory.getLogger(Consumer.class);
	 /**
	 * Amq service url
	 */
	private String url;
	 /**
	 * Amq queue
	 */
	private String subject;
	
	public Consumer(String url, String subject) 
	{
		super();
		this.url = url;
		this.subject = subject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	 @Override
	public void run() 
	{
		try 
		{
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			Connection connection = connectionFactory.createConnection();
			connection.setExceptionListener(this);
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(subject);
			MessageConsumer consumer = session.createConsumer(destination);
			consumer.setMessageListener(this);
		} catch (Exception e) 
		{
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/*
	 * Exec command
	 */
	private static void exec(Task task)
	{
		try
		{
			String cmd = null;
			switch(task.getStatus())
			{
				case "0":cmd="./startup.sh";break;
				case "1":cmd="./shutdown.sh";break;
				default: throw new Exception(task.getStatus());
			}
			ProcessBuilder processBuilder = new ProcessBuilder(cmd);
			processBuilder.directory(new File("/tmp/task/bin"));
			Process process = processBuilder.start();
			String line;
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((line = in.readLine()) != null) 
			{
				LOG.info(line);
			}
			process.waitFor();
		}catch(Exception e)
		{
			LOG.error(e.getMessage());
			e.printStackTrace();	
		}		
	}

   /*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage()
	 */
	@Override
	public void onMessage(Message message) 
	{
		try 
		{
			TextMessage msg = (TextMessage) message;
			LOG.info(msg.getText());
			exec(new Gson().fromJson(msg.getText(),Task.class));
		} catch (JMSException e) 
		{
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
	}

    /*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ExceptionListener#onException()
	 */
	@Override
	public synchronized void onException(JMSException e) 
	{
		LOG.error(e.getMessage());
	}
}
