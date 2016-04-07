package com.java.model.Bride;

public class AbstractMessage {
	/**
	 * 实现s
	 */
	MessageImplementor impl;

	public AbstractMessage(MessageImplementor impl) {
		this.impl = impl;
	}

	/**
	 * 发送消息
	 * 
	 * @param message
	 * @param toUser
	 */
	public void sendMessage(String message, String toUser) {
		this.impl.send(message, toUser);
	}
	
	public void setImpl(MessageImplementor impl){
		this.impl = impl;
	}
}
