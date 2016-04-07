package com.java.model.Bride;

/**
 * 消息实现
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
 * @version 2016-2-17 下午4:46:12
 */
public interface MessageImplementor {

	/**
	 * 发送消息
	 * 
	 * @param message
	 *            要发送消息的内容
	 * @param toUser
	 *            接收者
	 */
	public void send(String message, String toUser);
}
