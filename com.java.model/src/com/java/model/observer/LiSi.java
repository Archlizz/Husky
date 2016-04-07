package com.java.model.observer;

import java.util.Observable;
import java.util.Observer;

public class LiSi implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("李斯:观察到韩非子活动，开始向老板汇报了...");
		this.report(arg.toString());
		System.out.println("李斯：受到了赏赐!!!");
	}

	/**
	 * 报告
	 * 
	 * @param context
	 */
	private void report(String context) {
		System.out.println("李斯：报告发现韩非子正在" + context);
	}

}
