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
package com.nokia.radio.domain;

/**
 * 方案
 * 
 *  @author <a href="laixiaoxuan@gmail">Adrian LAI</a>
 *
 */
public class Plan
{	
	/**
	 * 唯一标示
	 */
	private String sessionId;
	/**
	 * 70003
	 */
	private String messageCode;
	/**
	 * 应用名称
	 */
	private String appName;
	/**
	 * 模块名称
	 */
	private String moudleName;
	/**
	 * 任务名称
	 */
	private String taskName;
	/**
	 * 运行周期
	 */
	private String period;
	/**
	 * 冗余字段1
	 */
	private String flag0;
	/**
	 * 冗余字段2
	 */
	private String flag1;
	/**
	 * 冗余字段3
	 */
	private String flag2;
	
	public String getSessionId() 
	{
		return sessionId;
	}
	public void setSessionId(String sessionId) 
	{
		this.sessionId = sessionId;
	}
	public String getMessageCode() 
	{
		return messageCode;
	}
	public void setMessageCode(String messageCode) 
	{
		this.messageCode = messageCode;
	}
	public String getAppName() 
	{
		return appName;
	}
	public void setAppName(String appName) 
	{
		this.appName = appName;
	}
	public String getMoudleName() 
	{
		return moudleName;
	}
	public void setMoudleName(String moudleName) 
	{
		this.moudleName = moudleName;
	}
	public String getTaskName() 
	{
		return taskName;
	}
	public void setTaskName(String taskName) 
	{
		this.taskName = taskName;
	}
	public String getPeriod() 
	{
		return period;
	}
	public void setPeriod(String period) 
	{
		this.period = period;
	}
	public String getFlag0() 
	{
		return flag0;
	}
	public void setFlag0(String flag0) 
	{
		this.flag0 = flag0;
	}
	public String getFlag1() 
	{
		return flag1;
	}
	public void setFlag1(String flag1) 
	{
		this.flag1 = flag1;
	}
	public String getFlag2() 
	{
		return flag2;
	}
	public void setFlag2(String flag2) 
	{
		this.flag2 = flag2;
	}
	
}
