package com.java.model.Flyweight;

/**
 * 唱片作者信息
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
 * @version 2016-2-2 下午4:30:20
 */
public class Artist {

	/**
	 * 姓名
	 */
	private String name;

	public String getName() {
		return this.name;
	}

	/**
	 * 构造函数
	 * 
	 * @param n
	 */
	public Artist(String n) {
		this.name = n;
	}
}
