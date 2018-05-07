package com.ubs.opsit.interviews.constant;

public class ErrorMessage {

	private ErrorMessage() {
	}

	public static final String EMPTY_INPUT_TIME_ERROR = "Empty time input. Please provide valid time as input";
	public static final String INCORRECT_LENGTH_INPUT_TIME_ERROR = "Time contains more than expected characters. "
			+ "Valid time input length is 8";
	public static final String INPUT_TIME_FORMAT_ERROR = "Incorrect input time format. Please enter time in format 'HH:mm:ss'";
	public static final String NON_NUMERIC_TIME_INPUT_ERROR = "Time input contains non numeric characters. "
			+ "Expected only numeric value for hour, minute and second";
	public static final String HOUR_OUT_OF_RANGE ="Hour value is out of range. The valid range for hour is 0-24";
	public static final String MINUTE_OUT_OF_RANGE ="Minute value is out of range. The valid range for minute is 0-59";
	public static final String SECOND_OUT_OF_RANGE ="Second value is out of range. The valid range for minute is 0-59";
}
