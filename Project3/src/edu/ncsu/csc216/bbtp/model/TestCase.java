/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

/**
 * Stores values for test cases and allows setting and getting of values
 * @author Joey Schauer
 */
public class TestCase extends Observable implements Serializable {
	/** the serial version UID for TestCase */
	private static final long serialVersionUID = 7459L;
	/** gets the test case id for the TestCase */
	private String testCaseID;
	/** gets the creation date and time as a Date object */
	private Date creationDateTime;
	/** gets the description for the test case */
	private String description;
	/** gets the expected results of the test case */
	private String expectedResults;
	/** gets the actual results of the test case */
	private String actualResults;
	/** gets the last tested date and time as a Date object */
	private Date lastTestedDateTime;
	/** true if the TestCase has been tested */
	private boolean testedStatus;
	/** true if the TestCase has passed it's test */
	private boolean pass;
	/** gets the testing type for the TestCase */
	private TestingType testingType;
	
	/**
	 * The constructor for TestCase
	 * @param id the id for the test case
	 * @param desc the description of the test case
	 * @param testingType the testing type of the test case
	 * @param creationDateTime the creation date and time for the test case
	 * @param expectedResults the expected results for the test case
	 * @param tested whether the test case has been tested or not
	 * @param lastTestedDate the last tested date for the test case
	 * @param actualResults the actual results for the test case
	 * @param pass whether the test case passed or not
	 */
	public TestCase(String id, String desc, TestingType testingType, Date creationDateTime, 
			String expectedResults, boolean tested, Date lastTestedDate, String actualResults, boolean pass) {
		setTestCaseID(id);
		setDescription(desc);
		setTestingType(testingType);
		setCreationDateTime(creationDateTime);
		setExpectedResults(expectedResults);
		testedStatus = tested;
		setLastTestedDateTime(lastTestedDate);
		setActualResults(actualResults);
		this.pass = pass;		
	}
	
	/**
	 * Returns the description for the test case
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the test case description with the given string
	 * @param description the description to set
	 * @throws IllegalArgumentException if the description is null, empty or just blank spaces
	 */
	public void setDescription(String description) {
		if (description == null || description.isEmpty() || description.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.description = description;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * Returns the expected results for the test case
	 * @return the expectedResults
	 */
	public String getExpectedResults() {
		return expectedResults;
	}
	
	/**
	 * Sets the test case's expected results to the given string
	 * @param expectedResults the expectedResults to set
	 * @throws IllegalArgumentException if the description is null, empty or just blank spaces
	 */
	public void setExpectedResults(String expectedResults) {
		if (expectedResults == null || expectedResults.isEmpty() || expectedResults.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.expectedResults = expectedResults;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * Returns the actual results for the test case
	 * @return the actualResults
	 */
	public String getActualResults() {
		return actualResults;
	}
	
	/**
	 * Sets the test case's actual results to the given string
	 * @param actualResults the actualResults to set
	 * @throws IllegalArgumentException if the description is null, empty or just blank spaces
	 */
	public void setActualResults(String actualResults) {
		if (testedStatus == true) {
			if (actualResults == null || actualResults.isEmpty() || actualResults.trim().isEmpty()) {
				throw new IllegalArgumentException();
			}
			this.actualResults = actualResults;
			setChanged();
			notifyObservers(this);
		}
	}
	
	/**
	 * Returns the creation date and time for the test case
	 * @return the creationDateTime
	 */
	public Date getCreationDateTime() {
		return creationDateTime;
	}
	
	/**
	 * Sets the test case's creation date and time to the given Date object
	 * @param creationDateTime the creationDateTime to set
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public void setCreationDateTime(Date creationDateTime) {
		if (creationDateTime == null) {
			throw new IllegalArgumentException();
		}
		this.creationDateTime = creationDateTime;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * Returns the last tested date and time for the test case
	 * @return the lastTestedDateTime
	 */
	public Date getLastTestedDateTime() {
		return lastTestedDateTime;
	}
	
	/**
	 * Sets the test case's last tested date and time to the given Date object
	 * @param lastTestedDateTime the lastTestedDateTime to set
	 */
	public void setLastTestedDateTime(Date lastTestedDateTime) {
		if (testedStatus == false || testedStatus == true && lastTestedDateTime != null) {
			this.lastTestedDateTime = lastTestedDateTime;
			setChanged();
			notifyObservers(this);
		}
	}
	
	/**
	 * Returns true if the test case has been tested
	 * @return true if the test case has been tested
	 */
	public boolean tested() {
		return testedStatus;
	}
	
	/**
	 * Sets the test case's tested status to the given parameter
	 * @param testedStatus the testedStatus to set
	 */
	public void setTestedStatus(boolean testedStatus) {
		this.testedStatus = testedStatus;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * Returns true if the test case has passed it's test
	 * @return true if the test case has passed it's test
	 */
	public boolean pass() {
		return pass;
	}
	
	/**
	 * Sets the test case's pass value to the given parameter
	 * @param pass the pass to set
	 */
	public void setPass(boolean pass) {
		this.pass = pass;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * Sets the test case's testing type to the given parameter
	 * @param t the testingType to set
	 * @throws IllegalArgumentException if the given parameter is null
	 */
	public void setTestingType(TestingType t) {
		if (t == null) {
			throw new IllegalArgumentException();
		}
		this.testingType = t;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * Returns the testing type for the test case
	 * @return the testingType
	 */
	public TestingType getTestingType() {
		return testingType;
	}
	
	/**
	 * Returns the test case id for the test case
	 * @return the testCaseID
	 */
	public String getTestCaseID() {
		return testCaseID;
	}
	
	/**
	 * Sets the test case's test case id to the given string
	 * @param id the testCaseID to set
	 * @throws IllegalArgumentException if the id is null or an empty string
	 */
	private void setTestCaseID(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.testCaseID = id;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * Determines whether two test cases are equal or not
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		TestCase other = (TestCase) o;
		if (other.getTestCaseID().equals(testCaseID)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Generates has code for this test case
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualResults == null) ? 0 : actualResults.hashCode());
		result = prime * result + ((creationDateTime == null) ? 0 : creationDateTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((expectedResults == null) ? 0 : expectedResults.hashCode());
		result = prime * result + ((lastTestedDateTime == null) ? 0 : lastTestedDateTime.hashCode());
		result = prime * result + (pass ? 1231 : 1237);
		result = prime * result + ((testCaseID == null) ? 0 : testCaseID.hashCode());
		result = prime * result + (testedStatus ? 1231 : 1237);
		result = prime * result + ((testingType == null) ? 0 : testingType.hashCode());
		return result;
	}
	
	/**
	 * Compares two test cases by their last tested date time value
	 * @param c the given test case to compare
	 * @return an integer value showing whether a test case's last date time is before equal to or after the given test case
	 */
	public int compareTo(TestCase c) {
		return this.lastTestedDateTime.compareTo(c.getLastTestedDateTime());
	}
}
