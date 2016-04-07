package com.java.model.Factory;

public class BlackHuman implements IHuman {
	
	@Override
	public void laugh() {
		System.out.println("黑色人在笑！！！");
	}

	@Override
	public void cry() {
		System.out.println("黑色人在哭！！！");
	}

	@Override
	public void talk() {
		System.out.println("黑色人在谈话！！！");
	}

}
