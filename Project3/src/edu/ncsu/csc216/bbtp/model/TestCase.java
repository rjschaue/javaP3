/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

/**
 * @author Joey Schauer
 *
 */
public class TestCase extends Observable implements Serializable {
	private static final long serialVersionUID = 7459L;
	private String testCaseID;
	private Date creationDateTime;
	private String description;
	private String expectedResults;
	private String actualResults;
	private Date lastTestedDateTime;
	private boolean testedStatus;
	private boolean pass;
	private TestingType testingType;
	
	public TestCase(String id, String desc, TestingType testingType, Date creationDateTime, 
			String expectedResults, boolean tested, Date lastTestedDate, String actualResults, boolean pass) {
		setTestCaseID(id);
		setDescription(desc);
		setTestingType(testingType);
		setCreationDateTime(creationDateTime);
		setExpectedResults(expectedResults);
		testedStatus = tested;
		setLastTestedDate(lastTestedDate);
		setActualResults(actualResults);
		this.pass = pass;		
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
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
	 * @return the expectedResults
	 */
	public String getExpectedResults() {
		return expectedResults;
	}
	
	/**
	 * @param expectedResults the expectedResults to set
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
	 * @return the actualResults
	 */
	public String getActualResults() {
		return actualResults;
	}
	
	/**
	 * @param actualResults the actualResults to set
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
	 * @return the creationDateTime
	 */
	public Date getCreationDateTime() {
		return creationDateTime;
	}
	
	/**
	 * @param creationDateTime the creationDateTime to set
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
	 * @return the lastTestedDateTime
	 */
	public Date getLastTestedDateTime() {
		return lastTestedDateTime;
	}
	
	/**
	 * @param lastTestedDateTime the lastTestedDateTime to set
	 */
	public void setLastTestedDateTime(Date lastTestedDateTime) {
		if (testedStatus != false && lastTestedDateTime == null) {
			throw new IllegalArgumentException();
		}
		this.lastTestedDateTime = lastTestedDateTime;
		setChanged();
		notifyObservers(this);
	}
	
	public boolean tested() {
		return testedStatus;
	}
	
	/**
	 * @param testedStatus the testedStatus to set
	 */
	public void setTestedStatus(boolean testedStatus) {
		this.testedStatus = testedStatus;
		setChanged();
		notifyObservers(this);
	}
	
	public boolean pass() {
		return pass;
	}
	
	/**
	 * @param pass the pass to set
	 */
	public void setPass(boolean pass) {
		this.pass = pass;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * @param t the testingType to set
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
	 * @return the testingType
	 */
	public TestingType getTestingType() {
		return testingType;
	}
	
	/**
	 * @return the testCaseID
	 */
	public String getTestCaseID() {
		return testCaseID;
	}
	
	/**
	 * @param id the testCaseID to set
	 */
	private void setTestCaseID(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.testCaseID = id;
		setChanged();
		notifyObservers(this);
	}

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
	
	public int compareTo(TestCase c) {
		return this.lastTestedDateTime.compareTo(c.getLastTestedDateTime());
	}
}
