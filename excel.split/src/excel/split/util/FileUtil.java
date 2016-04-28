package excel.split.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作
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
 * @version 2016-4-28 上午8:54:26
 */
public class FileUtil {

	/**
	 * 目录解析
	 * 
	 * @param path
	 * @return
	 */
	public static List<String> parseDirectory(String path) {
		// 文件名收集器
		List<String> fileCollection = new ArrayList<String>();
		if ("".equals(path) || path == null)
			return null;
		File f = new File(path);
		File[] files = f.listFiles();
		if (files == null || files.length == 0)
			return fileCollection;

		for (File file : files) {
			if (file.isDirectory())
				fileCollection.addAll(parseDirectory(file.getAbsolutePath()));
			else {
				String absPath = file.getAbsolutePath();
				if (absPath.endsWith(".xls") || absPath.endsWith(".xlsx"))
					fileCollection.add(absPath);
			}
		}
		return fileCollection;
	}

	/**
	 * 递归删除目录下的所有文件及子目录下所有文件
	 * 
	 * @param dir
	 *            将要删除的文件目录
	 * @return boolean Returns "true" if all deletions were successful. If a
	 *         deletion fails, the method stops attempting to delete and returns
	 *         "false".
	 */
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}
}
