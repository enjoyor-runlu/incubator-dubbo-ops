package com.enjoyor.dubbo.monitor.simple.domain;

import java.io.Serializable;

/**
 * 
 * @author Tempest
 *
 */
public class DubboInvoke implements Serializable {

	private static final long serialVersionUID = -5492791199795847100L;

	private Long dubboInvokeId;

	/**
	 * 提供者
	 */
	private String provider;

	/**
	 * 消费者
	 */
	private String consumer;

	/**
	 * 服务接口
	 */
	private String service;

	/**
	 * 方法名
	 */
	private String method;

	/**
	 * 类型
	 */
	private String type;

	private String invokeDate;

	private long invokeTime;

	private int success;

	private int failure;

	private int elapsed;

	private int concurrent;

	private int maxElapsed;

	private int maxConcurrent;

	private String modifyUser;

	public Long getDubboInvokeId() {
		return dubboInvokeId;
	}

	public void setDubboInvokeId(Long dubboInvokeId) {
		this.dubboInvokeId = dubboInvokeId;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInvokeDate() {
		return invokeDate;
	}

	public void setInvokeDate(String invokeDate) {
		this.invokeDate = invokeDate;
	}

	public long getInvokeTime() {
		return invokeTime;
	}

	public void setInvokeTime(long invokeTime) {
		this.invokeTime = invokeTime;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getFailure() {
		return failure;
	}

	public void setFailure(int failure) {
		this.failure = failure;
	}

	public int getElapsed() {
		return elapsed;
	}

	public void setElapsed(int elapsed) {
		this.elapsed = elapsed;
	}

	public int getConcurrent() {
		return concurrent;
	}

	public void setConcurrent(int concurrent) {
		this.concurrent = concurrent;
	}

	public int getMaxElapsed() {
		return maxElapsed;
	}

	public void setMaxElapsed(int maxElapsed) {
		this.maxElapsed = maxElapsed;
	}

	public int getMaxConcurrent() {
		return maxConcurrent;
	}

	public void setMaxConcurrent(int maxConcurrent) {
		this.maxConcurrent = maxConcurrent;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

}
