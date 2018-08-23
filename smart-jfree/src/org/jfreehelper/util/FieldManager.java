package org.jfreehelper.util;

import java.lang.reflect.Field;
import java.util.List;

public class FieldManager {
	private List<Field> valueKeyFieldList;
	private List<Field> IdentityFieldList;
	public List<Field> getValueKeyFieldList() {
		return valueKeyFieldList;
	}
	public void setValueKeyFieldList(List<Field> valueKeyFieldList) {
		this.valueKeyFieldList = valueKeyFieldList;
	}
	public List<Field> getIdentityFieldList() {
		return IdentityFieldList;
	}
	public void setIdentityFieldList(List<Field> identityFieldList) {
		IdentityFieldList = identityFieldList;
	}
	
	
	
}
