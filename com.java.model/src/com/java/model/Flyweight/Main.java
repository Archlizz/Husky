package com.java.model.Flyweight;

/**
 * 共享模式展示
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
 * @version 2016-2-2 下午5:05:49
 */
public class Main {

	public static void main(String[] args) {
		String info = "小明,2016,Greatest Hits|小明,2015,Taking Tiger Mountain";

		String[] infos = info.split("[|]");

		for (String item : infos) {
			String[] items = item.split(",");
			CD cd = new CD();
			cd.setYear(items[1]);
			cd.setTitle(items[2]);
			cd.setArtist(ArtistFactory.getInstance().getArtist(items[0]));

		}

	}
}
