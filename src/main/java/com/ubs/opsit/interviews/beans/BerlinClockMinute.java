package com.ubs.opsit.interviews.beans;

import static com.ubs.opsit.interviews.BerlinClock.MINUTE_FIRST_ROW_LAMP_COUNT;
import static com.ubs.opsit.interviews.BerlinClock.MINUTE_FIRST_ROW_TIME_UNIT;
import static com.ubs.opsit.interviews.beans.BerlinClockHand.adjustRowValue;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.interviews.BerlinClock;
import com.ubs.opsit.interviews.constant.Constants;

public class BerlinClockMinute implements BerlinClockHand {

	private List<Lamp> firstRow;
	private List<Lamp> secondRow;

	public BerlinClockMinute() {
		initialize();
	}

	private void initialize() {
		firstRow = new ArrayList<Lamp>();
		for (int i = 0; i < MINUTE_FIRST_ROW_LAMP_COUNT; i++) {
			Color color = Color.YELLOW;
			if (BerlinClock.MINUTE_RED_LAMP_POSITION.contains(i)) {
				color = Color.RED;
			}
			firstRow.add(new Lamp(color, MINUTE_FIRST_ROW_TIME_UNIT));
		}
		secondRow = new ArrayList<Lamp>();
		for (int i = 0; i < BerlinClock.MINUTE_SECOND_ROW_LAMP_COUNT; i++) {
			secondRow.add(new Lamp(Color.YELLOW, BerlinClock.MINUTE_SECOND_ROW_TIME_UNIT));
		}
	}

	public void adjust(int minute) {
		int mod = minute % MINUTE_FIRST_ROW_TIME_UNIT;
		int lampCountToOn = minute / MINUTE_FIRST_ROW_TIME_UNIT;
		adjustRowValue(firstRow, lampCountToOn);
		adjustRowValue(secondRow, mod);
	}

	@Override
	public String getValue() {
		final StringBuilder minute = new StringBuilder();
		firstRow.stream().forEach(l -> minute.append(l.getTime()));
		minute.append(Constants.CR_AND_NEW_LINE);
		secondRow.stream().forEach(l -> minute.append(l.getTime()));
		return minute.toString();
	}
}
