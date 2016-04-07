package com.java.model.observer;

import java.util.Observable;

public class HanFeiZi extends Observable {

	public void haveBreakfast() {
		System.out.println("韩非子吃早饭！！！！");
		this.setChanged();
		notifyObservers("韩非子吃早饭中");
	}

	public void haveFun() {
		System.out.println("韩非子开始娱乐!!!");
		this.setChanged();
		notifyObservers("韩非子娱乐中！");
	}

}
