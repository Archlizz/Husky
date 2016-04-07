package com.java.model.Bride;

/**
 * 普通消息
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
 * @version 2016-2-17 下午4:52:35
 */
public class CommonMessage extends AbstractMessage {

	public CommonMessage(MessageImplementor impl) {
		super(impl);
	}

	public void sendMessage(String message, String toUser) {
		super.sendMessage(message, toUser);
	}

}
