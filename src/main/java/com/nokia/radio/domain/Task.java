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
 * 作业
 * 
 *  @author <a href="laixiaoxuan@gmail.com">Adrian LAI</a>
 *
 */
public class Task 
{	
	/**
	 * 唯一标示
	 */
	private String sessionId;	
	/**
	 * 消息码
	 * 70001:启动任务
	 * 70002:停止任务
	 */
	private String messageCode;
	/**
	 * 应用名称
	 */
	private String appName;
	/**
	 * 模块名称
	 */
	private String moduleName;
	/**
	 * 任务名称
	 */
	private String taskName;
	/**
	 * 当前时间
	 */
	private String currTime;
	/**
	 * 当前任务状态
	 * 0：运行中
	 * 1：未运行
	 */
	private String status;
	/**
	 * 操作状态
	 * 0：启动任务
	 * 1：关闭任务
	 */
	private String operateStatus;
	/**
	 * 冗余字段1
	 */
	private String flag0;
	/**
	 * 冗余字段2
	 */
	private String flgg1;
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
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) 
	{
		this.appName = appName;
	}
	public String getModuleName() 
	{
		return moduleName;
	}
	public void setModuleName(String moduleName) 
	{
		this.moduleName = moduleName;
	}
	public String getTaskName() 
	{
		return taskName;
	}
	public void setTaskName(String taskName) 
	{
		this.taskName = taskName;
	}
	public String getCurrTime() 
	{
		return currTime;
	}
	public void setCurrTime(String currTime) 
	{
		this.currTime = currTime;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	public String getOperateStatus() 
	{
		return operateStatus;
	}
	public void setOperateStatus(String operateStatus) 
	{
		this.operateStatus = operateStatus;
	}
	public String getFlag0() 
	{
		return flag0;
	}
	public void setFlag0(String flag0) 
	{
		this.flag0 = flag0;
	}
	public String getFlgg1() 
	{
		return flgg1;
	}
	public void setFlgg1(String flgg1) 
	{
		this.flgg1 = flgg1;
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
