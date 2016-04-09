package com.java.model.responsibility;

public class Father extends Handler {

	public Father() {
		super(1);
	}

	@Override
	public void response(IWoman woman) {
		System.out.println("--------女儿向父亲请示-------");
		System.out.println(woman.getRequest());
		System.out.println("父亲的答复是：同意\n");
	}

}
