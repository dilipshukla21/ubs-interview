package com.ubs.opsit.interviews;

import java.util.HashSet;
import java.util.Set;

import com.ubs.opsit.interviews.beans.BerlinClockHand;
import com.ubs.opsit.interviews.beans.BerlinClockHour;
import com.ubs.opsit.interviews.beans.BerlinClockMinute;
import com.ubs.opsit.interviews.beans.BerlinClockSecond;
import com.ubs.opsit.interviews.parser.InputTimeParser;

public class BerlinClock implements TimeConverter {

	public static final int SECOND_TIME_UNIT = 2;
	public static final int HOUR_ROW_COUNT = 2;
	public static final int HOUR_FIRST_ROW_LAMP_COUNT = 4;
	public static final int HOUR_SECOND_ROW_LAMP_COUNT = 4;
	public static final int HOUR_FIRST_ROW_TIME_UNIT = 5;
	public static final int HOUR_SECOND_ROW_TIME_UNIT = 1;
	public static final int MINUTE_ROW_COUNT = 2;
	public static final int MINUTE_FIRST_ROW_TIME_UNIT = 5;
	public static final int MINUTE_SECOND_ROW_TIME_UNIT = 1;
	public static final int MINUTE_FIRST_ROW_LAMP_COUNT = 11;
	public static final int MINUTE_SECOND_ROW_LAMP_COUNT = 4;
	public static final Set<Integer> MINUTE_RED_LAMP_POSITION = new HashSet<Integer>();
	
	static {
		MINUTE_RED_LAMP_POSITION.add(2);
		MINUTE_RED_LAMP_POSITION.add(5);
		MINUTE_RED_LAMP_POSITION.add(8);
	}

	private BerlinClockHand secondHand;
	private BerlinClockHand hourHand;
	private BerlinClockHand minuteHand;

	public BerlinClock() {
		secondHand = new BerlinClockSecond();
		hourHand = new BerlinClockHour();
		minuteHand = new BerlinClockMinute();
	}

	private void adjustHands(int second, int hour, int minute) {
		secondHand.adjust(second);
		hourHand.adjust(hour);
		minuteHand.adjust(minute);
	}

	public String getTime() {
		return secondHand.getValue() + hourHand.getValue() + minuteHand.getValue();
	}

	@Override
	public String convertTime(String inputTime) {
		/*
		 * Had to write parser because LocalTime class do not support hour value as 24 
		 */
		InputTimeParser parser = new InputTimeParser(inputTime);
		parser.parse();
		adjustHands(parser.getSecond(), parser.getHour(), parser.getMinute());
		return getTime();
	}

}
