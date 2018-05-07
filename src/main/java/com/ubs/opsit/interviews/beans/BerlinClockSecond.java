package com.ubs.opsit.interviews.beans;

import com.ubs.opsit.interviews.BerlinClock;
import com.ubs.opsit.interviews.constant.Constants;

public class BerlinClockSecond implements BerlinClockHand {
	private final Lamp lamp = new Lamp(Color.YELLOW, BerlinClock.SECOND_TIME_UNIT);

	@Override
	public void adjust(int time) {
		if (time % BerlinClock.SECOND_TIME_UNIT == 0) {
			lamp.setOn(true);
		} else {
			lamp.setOn(false);
		}

	}

	@Override
	public String getValue() {
		return lamp.getTime()+Constants.CR_AND_NEW_LINE;
	}

}
