package org.aptech.t2004e.consts;

public enum DishCategoryEnum {
	MON_NUONG("mon_nuong") ,
	MON_LUOC("mon_luoc"),
	MON_CHAY("mon_chay"),
	DO_UONG("do_uong");
	
	public String value ;
	private DishCategoryEnum(String value) {
		this.value = value;
	}
}
