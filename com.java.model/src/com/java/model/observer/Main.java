package com.java.model.observer;

public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		HanFeiZi hanfeizi = new HanFeiZi();
		hanfeizi.addObserver(new LiSi());
		hanfeizi.haveBreakfast();
		Thread.sleep(1000);
		hanfeizi.haveFun();
	}

}
