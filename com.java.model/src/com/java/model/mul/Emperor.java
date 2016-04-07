package com.java.model.mul;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 多例模式
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
 * @version 2016-3-8 下午2:12:37
 */
public class Emperor {

	/**
	 * 最大数量
	 */
	private static int maxCountNum = 2;

	private static List<Emperor> emperorList = new ArrayList<Emperor>(
			maxCountNum);

	private static List<String> emperorInfoList = new ArrayList<String>(
			maxCountNum);

	private static int currentNum = 0;
	static {
		for (int i = 0; i < maxCountNum; i++) {
			emperorList.add(new Emperor("第" + i + "皇帝"));
		}
	}

	private Emperor() {
	}

	public Emperor(String info) {
		emperorInfoList.add(info);
	}

	public static Emperor getInstance() {
		long s = System.currentTimeMillis();
		Random r = new Random();
		currentNum = r.nextInt(maxCountNum);
		return emperorList.get(currentNum);
	}

	public static void getEmperorInfo() {
		System.out.println(emperorInfoList.get(currentNum));
	}
}
