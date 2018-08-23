package org.jfreehelper.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.jfreehelper.annotation.IdentityField;
import org.jfreehelper.annotation.ValueField;

public class DatasetUtil {
	//获取字段管理对象
	protected static FieldManager getFieldManager(Class<?> tempClass){
		FieldManager fm=new FieldManager();
		Field[] fieldArray=tempClass.getDeclaredFields();
		List<Field> valueKeyFieldList=new ArrayList<Field>();
		List<Field> identityKeyFieldList=new ArrayList<Field>();
		for (int i = 0; i < fieldArray.length; i++) {
			fieldArray[i].setAccessible(true);
			if(fieldArray[i].getAnnotation(ValueField.class)!=null){
				valueKeyFieldList.add(fieldArray[i]);
			}
			if(fieldArray[i].getAnnotation(IdentityField.class)!=null){
				identityKeyFieldList.add(fieldArray[i]);
			}
		}
		fm.setValueKeyFieldList(valueKeyFieldList);
		fm.setIdentityFieldList(identityKeyFieldList);
		return fm;
	}
	//获取作为数据集value的字段值
	protected static Double getFieldValue(Field field,Object obj){
		try {
			Double value=(Double) field.get(obj);
			return value;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return 0d;
	}
	//获取字段注解描述
	protected static String getFieldAnnotationValue(Field field){
		String description="none";
		if(field.getAnnotation(ValueField.class)!=null){
			description= field.getAnnotation(ValueField.class).description();
		}
		return description;
	}
	//获取字段的值
	protected static String getKeyValue(Field field,Object obj){
		String keyValue="none";
		try {
			keyValue = field.get(obj).toString();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return keyValue;
	}

}
