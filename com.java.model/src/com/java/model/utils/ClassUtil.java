package com.java.model.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * class util
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
 * @version 2016-3-9 下午3:01:50
 */
public class ClassUtil {
	public static List<Class> getAllClassByInterface(Class c) {
		List<Class> classList = new ArrayList<Class>();
		if (c.isInterface()) {
			String packageName = c.getPackage().getName();
			System.out.println(packageName);
		}
		return null;
	}

	public static List<Class> getClasses(String packageName) throws IOException {
		//当前
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		packageName = packageName.replaceAll(".", "/");
		Enumeration<URL> resources = classLoader.getResources(packageName);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		List<Class> classes = new ArrayList<Class>();
		for (File dir : dirs) {
			classes.addAll(findClasses(dir, packageName));
		}
		return null;

	}

	public static List<Class> findClasses(File directory, String packageName) {
		List<Class> classList = new ArrayList<Class>();
		if (!directory.exists())
			return classList;
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				// 是目录，继续递归查找
			} else if (file.getName().endsWith(".class")) {

			}

		}
		return null;
	}

}
