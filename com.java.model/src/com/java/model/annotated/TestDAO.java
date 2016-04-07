package com.java.model.annotated;

/**
 * test DAO
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
 * @version 2016-3-24 上午11:49:27
 */
@Table(Name = "TEST_DAO")
public class TestDAO {

	@Column
	private String col1;

	@Column
	private String col2;

	@Column
	private String col3;

	/**
	 * @return the col1
	 */
	public String getCol1() {
		return col1;
	}

	/**
	 * @param col1
	 *            the col1 to set
	 */
	public void setCol1(String col1) {
		this.col1 = col1;
	}

	/**
	 * @return the col2
	 */
	public String getCol2() {
		return col2;
	}

	/**
	 * @param col2
	 *            the col2 to set
	 */
	public void setCol2(String col2) {
		this.col2 = col2;
	}

	/**
	 * @return the col3
	 */
	public String getCol3() {
		return col3;
	}

	/**
	 * @param col3
	 *            the col3 to set
	 */
	public void setCol3(String col3) {
		this.col3 = col3;
	}
}
