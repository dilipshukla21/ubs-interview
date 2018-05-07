package com.ubs.opsit.interviews.parser;

import com.ubs.opsit.interviews.constant.Constants;
import com.ubs.opsit.interviews.constant.ErrorMessage;
/**
 * 
 * Parses the time input for clock
 *
 */
public class InputTimeParser {
	private int hour;
	private int minute;
	private int second;

	private final String inputTime;

	public InputTimeParser(String inputTime) {
		this.inputTime = inputTime;
	}

	public void parse() {
		if (inputTime == null || inputTime.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_TIME_ERROR);
		}

		if (inputTime.length() > 8) {
			throw new IllegalArgumentException(ErrorMessage.INCORRECT_LENGTH_INPUT_TIME_ERROR);
		}
		String[] time = inputTime.split(":");
		if (time.length != 3) {
			throw new IllegalArgumentException(ErrorMessage.INPUT_TIME_FORMAT_ERROR);
		}

		try {
			this.hour = Integer.parseInt(time[0]);
			this.minute = Integer.parseInt(time[1]);
			this.second = Integer.parseInt(time[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_TIME_INPUT_ERROR);
		}

		validateRange(hour, Constants.MIN_HAND_TIME_UNIT, Constants.MAX_HOUR, ErrorMessage.HOUR_OUT_OF_RANGE);
		validateRange(hour, Constants.MIN_HAND_TIME_UNIT, Constants.MAX_MINUTE, ErrorMessage.MINUTE_OUT_OF_RANGE);
		validateRange(hour, Constants.MIN_HAND_TIME_UNIT, Constants.MAX_SECOND, ErrorMessage.SECOND_OUT_OF_RANGE);
	}

	private void validateRange(int valueToTest, int minValue, int maxValue, String message) {
		if (valueToTest < minValue || valueToTest > maxValue) {
			throw new IllegalArgumentException(message);
		}
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

}
