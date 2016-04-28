package excel.split;

import java.io.File;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import excel.split.util.JExcelParser;

public class Main {

	private static Logger logger = LoggerFactory.getLogger(Main.class);

	private String basePath = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.init();
		System.out.print("请输入表头行数:");
		Scanner scan = new Scanner(System.in);
		String read = scan.nextLine();
		int count = 0;
		try {
			count = Integer.valueOf(read);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			count = 2;
		}
		logger.debug("表头行数为:" + count + "开始处理!!!");
		JExcelParser parser = new JExcelParser(main.getBasePath()
				+ "\\data\\src", main.getBasePath() + "\\data\\dst", count);
		parser.excelParse();
		parser.statis();
		logger.debug("处理完成");
	}

	/**
	 * @return the basePath
	 */
	public String getBasePath() {
		return basePath;
	}

	/**
	 * 初始化
	 */
	public void init() {
		basePath = new File("").getAbsolutePath();
		loadLogbackConfig();
	}

	/**
	 * 加载日志配置文件
	 * 
	 */
	private void loadLogbackConfig() {

		File configlogbackFile = new File(basePath + "\\logback.xml");

		// 4、加载logback.xml
		try {
			LoggerContext lc = (LoggerContext) LoggerFactory
					.getILoggerFactory();
			JoranConfigurator configurator = new JoranConfigurator();
			lc.stop();
			lc.reset();
			configurator.setContext(lc);
			if (configlogbackFile != null && configlogbackFile.exists()) {
				configurator.doConfigure(configlogbackFile);
			}
			lc.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
