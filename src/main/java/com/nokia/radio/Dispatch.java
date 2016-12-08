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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.nokia.radio.domain.Plan;
import com.nokia.radio.domain.Task;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 调度器
 * 
 * @author <a href="laixiaoxuan@gmail.com">Adrian LAI</a>
 *
 */
public class Dispatch 
{
	/**
	 * slf4j logger interface
	 */
	protected static final transient Logger LOG = LoggerFactory.getLogger(Dispatch.class);

	/**
	 * Main.
	 */
	public static void main(String[] args) throws Exception
	{
		String operation = null;
		do
		{
			System.out.print("Consume or produce? [c/p]: ");
			operation = readInput();
		}while(!operation.equals("c")&&!operation.equals("p")&&!operation.equals("test"));
		
		System.out.print("Url?: ");
		String url = readInput();
		System.out.print("Queue?: ");
		String queue = readInput();
		
		switch (operation) 
		{
		case "c":new Consumer(url, queue).start();break;
		case "p":
		    System.out.print("Period?: ");
			String period = readInput();
			Plan plan = new Plan();
			plan.setSessionId(UUID.randomUUID().toString());
			plan.setMessageCode("70003");
			plan.setAppName("LTEiCES");
			plan.setMoudleName("Test");
			plan.setTaskName("simpleTask");
			plan.setPeriod(period);
			plan.setFlag0("");
			plan.setFlag1("");
			plan.setFlag2("");
			new Producer(url, queue, new Gson().toJson(plan)).start();
			break;
		case "test":
		    System.out.print("status?: ");
			String status = readInput();
			Task task = new Task();
			task.setStatus(status);
			new Producer(url, queue, new Gson().toJson(task)).start();
			break;
		}
	}
	
	/**
	 * Read a line from System.in.
	 */
	private static String readInput() throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) 
		{
			return line;
		}
		return null;
	}

}
