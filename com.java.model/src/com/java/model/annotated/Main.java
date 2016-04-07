package com.java.model.annotated;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestDAO dao = new TestDAO();
		dao.setCol1("11111");
		dao.setCol2("22222");
		dao.setCol3("33333");
		AnnotatedElement element = dao.getClass();
		// 获取表名
		Table t = element.getAnnotation(Table.class);
		System.out.println(t.Name());

		Field[] fields = dao.getClass().getDeclaredFields();
		for (Field field : fields) {
			AnnotatedElement annElement = field;
			Column column = annElement.getAnnotation(Column.class);
			System.out.println(("").equals(column.Name()) ? field.getName() : column.Name());
		}
	}

}
