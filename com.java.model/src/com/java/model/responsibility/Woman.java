package com.java.model.responsibility;

public class Woman implements IWoman {

	private int type = 1;

	private String request = "";

	public Woman(int type, String _request) {
		this.type = type;
		switch (type) {
		case 1:
			this.request = "女儿的请求是：" + _request;
			break;
		case 2:
			this.request = "妻子的请求是：" + _request;
			break;
		case 3:
			this.request = "母亲的请求是：" + _request;
			break;
		default:
			System.out.println("类型未知");
			break;
		}
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public String getRequest() {
		return request;
	}

}
