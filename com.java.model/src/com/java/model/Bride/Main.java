package com.java.model.Bride;

/**
 * 桥模式展示
 * 
 * <DL>
 * <DT><B>标题</B></DT>
 * <p>
 * <DD>详细介绍</DD>
 * </DL>
 * <p>
 * 
 * <DL>
 * <DT><B>范例</B></DT>
 * <p>
 * <DD>范例说明</DD>
 * </DL>
 * <p>
 * 
 * @author 廖志杰
 * @author 浙江宇信班克信息技术有限公司
 * @version 1.0.0
 * @version 2016-2-2 下午5:07:17
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MessageImplementor impl;
		// 通过短信方式
		impl = new MessageSMS();
		// 将普通消息通过短信方式发送
		AbstractMessage message = new CommonMessage(impl);
		message.sendMessage("only for test!!!", "LiMing");
		
		message = new UrgencyMessage(impl);
		message.sendMessage("only for test!!!", "LiMing");
		
		message.setImpl(new MessageMobile());
		message.sendMessage("only for test!!!", "LiMing");
	}
}
