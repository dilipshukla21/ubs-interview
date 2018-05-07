package com.ubs.opsit.interviews.beans;

public class Lamp {
	private static final String OFF_STATUS = "O";
	private final Color color;
	private final int timeUnit;
	private boolean on;

	public Lamp(Color color, int timeUnit) {
		super();
		this.color = color;
		this.timeUnit = timeUnit;
		this.on = false;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public Color getColor() {
		return color;
	}

	public int getTimeUnit() {
		return timeUnit;
	}

	public String getTime() {
		if (on) {
			return color.getDisplayName();
		} else {
			return OFF_STATUS;
		}
	}
}
