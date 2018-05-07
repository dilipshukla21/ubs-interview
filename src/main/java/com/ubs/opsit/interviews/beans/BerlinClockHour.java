package com.ubs.opsit.interviews.beans;

import static com.ubs.opsit.interviews.BerlinClock.HOUR_FIRST_ROW_LAMP_COUNT;
import static com.ubs.opsit.interviews.BerlinClock.HOUR_FIRST_ROW_TIME_UNIT;
import static com.ubs.opsit.interviews.beans.BerlinClockHand.adjustRowValue;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.interviews.BerlinClock;
import com.ubs.opsit.interviews.constant.Constants;

public class BerlinClockHour implements BerlinClockHand {
	private List<Lamp> firstRow;
	private List<Lamp> secondRow;

	public BerlinClockHour() {
		initialize();
	}

	private void initialize() {
		firstRow = new ArrayList<Lamp>();
		for (int i = 0; i < HOUR_FIRST_ROW_LAMP_COUNT; i++) {
			firstRow.add(new Lamp(Color.RED, HOUR_FIRST_ROW_TIME_UNIT));
		}
		secondRow = new ArrayList<Lamp>();
		for (int i = 0; i < BerlinClock.HOUR_SECOND_ROW_LAMP_COUNT; i++) {
			secondRow.add(new Lamp(Color.RED, BerlinClock.HOUR_SECOND_ROW_TIME_UNIT));
		}
	}

	public void adjust(int hour) {
		int mod = hour % HOUR_FIRST_ROW_TIME_UNIT;
		int lampCountToOn = hour / HOUR_FIRST_ROW_TIME_UNIT;
		adjustRowValue(firstRow, lampCountToOn);
		adjustRowValue(secondRow, mod);

	}

	@Override
	public String getValue() {
		final StringBuilder hour = new StringBuilder();
		firstRow.stream().forEach(l -> hour.append(l.getTime()));
		hour.append(Constants.CR_AND_NEW_LINE);
		secondRow.stream().forEach(l -> hour.append(l.getTime()));
		hour.append(Constants.CR_AND_NEW_LINE);
		return hour.toString();
	}

}
