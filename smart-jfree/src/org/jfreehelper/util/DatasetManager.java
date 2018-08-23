package org.jfreehelper.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfreehelper.annotation.ValueField;

public class DatasetManager {
	
	public static DefaultCategoryDataset getDataset(List<?> list,boolean isReverse){
		DefaultCategoryDataset ds=new DefaultCategoryDataset();
		if(list!=null&&list.size()>0){
			Class<?> tempClass=list.get(0).getClass();
			FieldManager fm=DatasetUtil.getFieldManager(tempClass);
			List<Field> valueKeyFieldList= fm.getValueKeyFieldList();
			List<Field> identityFieldList=fm.getIdentityFieldList();
			Iterator<?> itr=list.iterator();
			while(itr.hasNext()){
				Object obj=itr.next();
				for (int i = 0; i < valueKeyFieldList.size(); i++) {
					for (int j = 0; j < identityFieldList.size(); j++) {
							Double value=DatasetUtil.getFieldValue(valueKeyFieldList.get(i),obj);
							String rowkey=DatasetUtil.getFieldAnnotationValue(valueKeyFieldList.get(i));
							String columnKey=DatasetUtil.getKeyValue(identityFieldList.get(j), obj);
							if(isReverse){
								ds.addValue(value,columnKey,rowkey);
							}else{
								ds.addValue(value, rowkey, columnKey);
							}
					}
				}
			}
		}
		return ds;
	}
	//更新数据集,要求pageValue数组里的值对应实体类的注解valueField的pageValue
	public static DefaultCategoryDataset updateDataset(List<?> list,String[] pageValues,boolean isReverse){
		DefaultCategoryDataset ds=getDataset(list, isReverse);
		if(pageValues!=null){
			List<String> items=Arrays.asList(pageValues);
			Map<String,String> fieldAnnotations=getFieldAnnotationsMap(list.get(0).getClass());
			if(isReverse){
				for (String key:fieldAnnotations.keySet()) {
					if(!items.contains(key))
						ds.removeColumn(fieldAnnotations.get(key));
				}
			}else{
				for (String key:fieldAnnotations.keySet()) {
					if(!items.contains(key))
						ds.removeRow(fieldAnnotations.get(key));
				}
			}
		}
		return ds;
	}
	//创建映射Map
	public static Map<String,String> getFieldAnnotationsMap(Class<?> classTemp){
		FieldManager fm=DatasetUtil.getFieldManager(classTemp);
		List<Field> fieldList=fm.getValueKeyFieldList();
		Map<String,String> fieldAnnotations=new HashMap<String,String>();
		for (int i = 0; i < fieldList.size(); i++) {
			String description=fieldList.get(i).getAnnotation(ValueField.class).description();
			String pageValue=fieldList.get(i).getAnnotation(ValueField.class).pageValue();
			fieldAnnotations.put(pageValue, description);
		}
		return fieldAnnotations;
	}
}
