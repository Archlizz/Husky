package com.java.model.Flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 唱片作者信息工厂
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
 * @version 2016-2-2 下午4:35:20
 */
public class ArtistFactory {
	Map<String, Artist> map = new HashMap<String, Artist>();
	private static ArtistFactory instance = null;

	public static ArtistFactory getInstance() {
		if (instance == null) {
			instance = new ArtistFactory();
		}
		return instance;
	}

	public Artist getArtist(String key) {
		Artist artist = null;
		artist = map.get(key);
		if (artist == null) {
			System.out.println(key + "正在制造，准备出厂");
			artist = new Artist(key);
			map.put(key, artist);
		} else {
			System.out.println(key + ",工厂有存货直接出厂");
		}
		return artist;
	}

}
