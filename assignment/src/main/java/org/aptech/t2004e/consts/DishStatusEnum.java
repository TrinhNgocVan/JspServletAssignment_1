package org.aptech.t2004e.consts;

public enum DishStatusEnum {
	DANG_BAN("On sale") ,
	DUNG_BAN("Stop selling"),
	DA_XOA("Deleted");
	
	public String value ;
	private DishStatusEnum(String value) {
		this.value = value;
	}
}
