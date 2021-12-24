package org.aptech.t2004e.consts;

public enum PaggingEnum {
	PAGE (1),
	SIZE(5);
	
	
	public int value ;
	private PaggingEnum(int value) {
		this.value = value;
	}
}
