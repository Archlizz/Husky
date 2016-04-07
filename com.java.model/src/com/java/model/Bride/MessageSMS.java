package com.java.model.Bride;

public class MessageSMS implements MessageImplementor {

	@Override
	public void send(String message, String toUser) {
		System.out.println("通过短信方式，将消息:" + message + "发送给了" + toUser);
	}

}
