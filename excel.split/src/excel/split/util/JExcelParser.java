package excel.split.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Excel 解析器
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
 * @version 2016-4-28 上午9:07:04
 */
public class JExcelParser {

	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(JExcelParser.class);

	/**
	 * 成功计数器
	 */
	private int succeedCount = 0;

	/**
	 * 
	 */
	private int maxNum = 0;

	/**
	 * 转换完成的表单数量
	 */
	private int sheetCount = 0;

	/**
	 * 处理失败文件列表
	 */
	private List<String> failList = new ArrayList<String>();

	/**
	 * 源
	 */
	private String src = "";

	private String dst = "";

	private int headCount = 2;

	public JExcelParser(String src, String dst) {
		this(src, dst, 2);
	}

	public JExcelParser(String src, String dst, int headCount) {
		this.src = src;
		this.dst = dst;
		this.headCount = headCount;
	}

	/**
	 * 解析
	 * 
	 * @param path
	 * @param dstPath
	 */
	public void excelParse() {
		List<String> pathList = FileUtil.parseDirectory(src);
		maxNum = pathList.size();
		if (maxNum == 0)
			logger.error("二货，你是不是把文件位置给放错了啊！！！！哈哈哈呵呵！！！");
		// 遍历所有文件
		for (String item : pathList) {
			try {
				File file = new File(item);
				String fileName = file.getName();
				String ext = fileName.substring(fileName.lastIndexOf("."));
				fileName = fileName.substring(0, fileName.lastIndexOf("."));
				logger.info("开始解析文件!!![" + fileName + "]");
				long s = System.currentTimeMillis();
				Workbook workbook = Workbook.getWorkbook(new File(item));
				WritableWorkbook dstWorkbook = null;
				int numberOfSheets = workbook.getNumberOfSheets();
				logger.debug("文件:" + fileName + ",共包含" + numberOfSheets
						+ "个表单!");
				File pD = new File(dst + "\\" + fileName);
				if (!pD.exists())
					pD.mkdirs();
				else {
					FileUtil.deleteDir(pD);
					pD.mkdirs();
				}
				for (int j = 0; j < numberOfSheets; j++) {
					Sheet sheet = workbook.getSheet(j);
					try {
						File dp = new File(dst + "\\" + fileName,
								sheet.getName() + ext);
						dstWorkbook = Workbook.createWorkbook(dp);
						WritableSheet wSheet = dstWorkbook.createSheet(
								sheet.getName(), 0);
						copySheet(wSheet, sheet);
						dstWorkbook.write();
					} catch (Exception e) {
						throw e;
					} finally {
						dstWorkbook.close();
					}
					logger.debug("文件：" + fileName + ",表单：" + sheet.getName()
							+ "处理成功！！！！");
				}
				succeedCount++;
				sheetCount += numberOfSheets;
				long cost = System.currentTimeMillis() - s;
				logger.info("文件[" + fileName + "],解析完成,耗时：" + cost + "ms");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				failList.add(item);
			}
		}

	}

	/**
	 * copy
	 * 
	 * @param wsheet
	 * @param srcSheet
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private void copySheet(WritableSheet wsheet, Sheet srcSheet)
			throws RowsExceededException, WriteException {

		// 设置字体;
		WritableFont font1 = new WritableFont(WritableFont.createFont("宋体"), 12);

		WritableCellFormat cellFormat1 = new WritableCellFormat(font1);
		// 设置背景颜色;
		// cellFormat1.setBackground(Colour.BLUE_GREY);
		// 设置边框;
		cellFormat1.setBorder(Border.NONE, BorderLineStyle.DASH_DOT);
		// 设置自动换行;
		cellFormat1.setWrap(true);
		// 设置文字居中对齐方式;
		cellFormat1.setAlignment(Alignment.LEFT);
		// 设置垂直居中;
		cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);

		// 设置字体;
		WritableFont headFont = new WritableFont(
				WritableFont.createFont("Arial"), 9);

		WritableCellFormat headFormat = new WritableCellFormat(headFont);
		// 设置背景颜色;
		headFormat.setBackground(Colour.LIGHT_ORANGE);
		// 设置边框;
		headFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		// 设置自动换行;
		headFormat.setWrap(true);
		// 设置文字居中对齐方式;
		headFormat.setAlignment(Alignment.LEFT);
		// 设置垂直居中;
		headFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		wsheet.getSettings().setDefaultColumnWidth(18);
		int cols = srcSheet.getColumns();
		int rows = srcSheet.getRows();
		// 头两行单独处理
		for (int i = 0; i < headCount; i++) {
			for (int j = 0; j < cols; j++) {
				Cell cell = srcSheet.getCell(j, i);
				Label label = new Label(j, i, cell.getContents());
				label.setCellFormat(headFormat);
				wsheet.addCell(label);
			}
		}

		for (int i = headCount; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Cell cell = srcSheet.getCell(j, i);
				Label label = new Label(j, i, cell.getContents());
				label.setCellFormat(cellFormat1);
				wsheet.addCell(label);
			}
		}

	}

	/**
	 * 写表头
	 * 
	 * @param wsheet
	 * @return
	 * @throws Exception
	 */
	private WritableSheet writeHead(WritableSheet wsheet) throws Exception {
		// 设置字体;
		WritableFont font1 = new WritableFont(WritableFont.TIMES, 14);

		WritableCellFormat cellFormat1 = new WritableCellFormat(font1);
		// 设置背景颜色;
		// cellFormat1.setBackground(Colour.BLUE_GREY);
		// 设置边框;
		cellFormat1.setBorder(Border.NONE, BorderLineStyle.DASH_DOT);
		// 设置自动换行;
		cellFormat1.setWrap(true);
		// 设置文字居中对齐方式;
		cellFormat1.setAlignment(Alignment.CENTRE);
		// 设置垂直居中;
		cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);
		WritableCellFeatures feature = new WritableCellFeatures();
		feature.removeComment();
		Label label = null;
		int cols = wsheet.getColumns();
		for (int row = 0; row < 2; row++)
			for (int i = 0; i < cols; i++) {
				WritableCell cell = wsheet.getWritableCell(i, row);

				// String content = cell.getContents();
				cell.setCellFormat(cellFormat1);
				cell.setCellFeatures(feature);
			}
		return wsheet;
	}

	/**
	 * 结果统计
	 */
	public void statis() {
		System.out.println("待解析文件共" + maxNum + "个");
		System.out.print("成功个数:" + succeedCount + "个,");
		System.out.println("共生成" + sheetCount + "个表单");
		int len = failList.size();
		System.out.println("失败个数:" + len);
		if (len > 0) {
			System.out.println("失败信息如下：");
			for (int i = 0; i < len; i++) {
				System.out.println(failList.get(i));
			}
		}
	}
}
