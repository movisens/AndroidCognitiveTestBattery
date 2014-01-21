package com.movisens.xs.android.cognition.emo_stroop;

import java.io.Serializable;

/**
 * A data structure to hold the test result of a single word. 
 * 
 * @author Stephan Grund
 *
 */
public class Result implements Serializable {
	private static final long serialVersionUID = -1576930313968501520L;
	public final long reaction;
	public final String testWord, choice;

	/**
	 * Sets the data of one test result.
	 * 
	 * @param reaction The time in milliseconds the choice took.
	 * @param testWord The assessed word.
	 * @param choice The chosen color for the word.
	 */
	public Result(long reaction, String testWord, String choice) {
		this.reaction = reaction;
		this.choice = choice;
		this.testWord = testWord;
	}
	
	private String toCSVLine() {
		return "reaction=" + reaction + "|choice=" + choice + "|testWord=" + testWord;
	}
	
	public String toString()
	{
		return toCSVLine();
	}
}
