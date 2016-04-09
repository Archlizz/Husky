package com.java.model.responsibility;

/**
 * 处理者
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
 * @version 2016-4-7 下午4:38:18
 */
public abstract class Handler {

	/**
	 * 处理者等级
	 */
	private int level = 0;

	/**
	 * 下一个处理者
	 */
	private Handler nextHandler;

	/**
	 * 
	 * @param _level
	 */
	protected Handler(int _level) {
		this.level = _level;
	}

	/**
	 * 处理消息
	 * 
	 * @param woman
	 */
	public void handlerMessage(IWoman woman) {
		if (woman.getType() == this.level)
			this.response(woman);
		else {
			if (nextHandler != null) {
				nextHandler.handlerMessage(woman);
			} else {
				this.defaultResponse(woman);
			}
		}
	}

	/**
	 * 默认的消息响应器
	 * 
	 * @param woman
	 */
	private void defaultResponse(IWoman woman) {
		System.out.println("类型未知，不进行处理");
	}

	/**
	 * set next Handler
	 * 
	 * @param next
	 */
	public void setNextHandler(Handler next) {
		this.nextHandler = next;
	}

	/**
	 * 回应
	 * 
	 * @param woman
	 */
	public abstract void response(IWoman woman);
}
