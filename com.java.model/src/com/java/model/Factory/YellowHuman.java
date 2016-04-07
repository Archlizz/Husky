package com.java.model.Factory;

public class YellowHuman implements IHuman {

	@Override
	public void laugh() {
		System.out.println("黄色人在笑！！！");
	}

	@Override
	public void cry() {
		System.out.println("黄色人在哭！！！");
	}

	@Override
	public void talk() {
		System.out.println("黄色人在谈话！！！");
	}

}
