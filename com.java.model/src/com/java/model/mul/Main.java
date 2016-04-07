package com.java.model.mul;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 定义10个大臣
		for (int i = 1; i <= 10; i++) {
			System.out.print("大臣" + i + "拜见");
			Emperor.getInstance().getEmperorInfo();

		}
	}

}
