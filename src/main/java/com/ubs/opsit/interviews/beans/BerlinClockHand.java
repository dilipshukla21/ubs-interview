package com.ubs.opsit.interviews.beans;

import java.util.List;

public interface BerlinClockHand {
	void adjust(int time);
	String getValue();
	
	static void adjustRowValue(List<Lamp> row, int lampCountToOn) {
		int onLampCount = 0;
		for (Lamp lamp : row) {
			if (onLampCount < lampCountToOn) {
				lamp.setOn(true);
				onLampCount++;
			} else {
				lamp.setOn(false);
			}
		}
	}
}
