package com.java.model.Factory;

import com.java.model.utils.ClassUtil;

/**
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
 * @version 2016-3-9 下午2:16:51
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IHuman human = HumanFactory.createHuman(WhiteHuman.class);
		if(human!=null){
			System.out.println("白色人创造成功！");
			human.cry();
			human.laugh();
			human.talk();
		}else
			System.out.println("白色人创造失败!");
		ClassUtil.getAllClassByInterface(IHuman.class);
	}
}
