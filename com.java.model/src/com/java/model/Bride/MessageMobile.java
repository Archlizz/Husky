package com.java.model.Bride;

public class MessageMobile implements MessageImplementor {

	@Override
	public void send(String message, String toUser) {
		System.out.println("通过手机方式，将消息:" + message + "发送给了" + toUser);
	}

}
