package com.ubs.opsit.interviews.beans;

public enum Color {

	RED("R"),YELLOW("Y");
	private String displayName;
	private Color(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
}
