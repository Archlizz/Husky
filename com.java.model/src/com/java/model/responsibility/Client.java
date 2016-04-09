package com.java.model.responsibility;

import java.util.Random;

/**
 * 责任链模式示例
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
 * @version 2016-4-7 下午6:09:37
 */
public class Client {

	public static void main(String[] args) throws Throwable {
		// 随机挑选几个女性
		Random rand = new Random();
		Handler father = new Father();
		Handler husband = new Husband();
		Handler son = new Son();
		father.setNextHandler(husband);
		husband.setNextHandler(son);
		for (int i = 0; i < 10; i++) {
			father.handlerMessage(new Woman(rand.nextInt(4) + 1, "我要出去逛街"));
			Thread.sleep(200);
		}
	}
}
