package com.java.model.Flyweight;

/**
 * cd类
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
 * @version 2016-2-2 下午4:32:30
 */
public class CD {

	/**
	 * 唱片年份
	 */
	private String year;

	/**
	 * 唱片名称
	 */
	private String title;

	/**
	 * 作者信息
	 */
	private Artist artist;

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the artist
	 */
	public Artist getArtist() {
		return artist;
	}

	/**
	 * @param artist
	 *            the artist to set
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
