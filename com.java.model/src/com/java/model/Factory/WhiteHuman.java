package com.java.model.Factory;

public class WhiteHuman implements IHuman {

	@Override
	public void laugh() {
		System.out.println("白色人在笑！！！");
	}

	@Override
	public void cry() {
		System.out.println("白色人在哭！！！");
	}

	@Override
	public void talk() {
		System.out.println("白色人在谈话！！！");
	}

}
