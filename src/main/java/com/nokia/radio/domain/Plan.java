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
	 * 运行方案
	 * 立即执行<now>/每周<week>/每月<month>/每天<day>/15分钟<15mi>
	 */
	private String caseRule;
	/**
	 * 运行开始时间，以分钟为最小粒度
	 * 2016-12-08 16:22
	 */
	private String curTime;
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
	public String getCaseRule() 
	{
		return caseRule;
	}
	public void setCaseRule(String caseRule) 
	{
		this.caseRule = caseRule;
	}
	public String getCurTime() 
	{
		return curTime;
	}
	public void setCurTime(String curTime) 
	{
		this.curTime = curTime;
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
