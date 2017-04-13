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
		//TODO implement constructor
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
		this.description = description;
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
		this.expectedResults = expectedResults;
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
		this.actualResults = actualResults;
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
		this.creationDateTime = creationDateTime;
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
		this.lastTestedDateTime = lastTestedDateTime;
	}
	
	public boolean tested() {
		return false;
	}
	
	/**
	 * @param testedStatus the testedStatus to set
	 */
	public void setTestedStatus(boolean testedStatus) {
		this.testedStatus = testedStatus;
	}
	
	public boolean pass() {
		return false;
	}
	
	/**
	 * @param pass the pass to set
	 */
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
	/**
	 * @param t the testingType to set
	 */
	public void setTestingType(TestingType t) {
		this.testingType = t;
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
		this.testCaseID = id;
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
		if (actualResults == null) {
			if (other.actualResults != null)
				return false;
		} else if (!actualResults.equals(other.actualResults))
			return false;
		if (creationDateTime == null) {
			if (other.creationDateTime != null)
				return false;
		} else if (!creationDateTime.equals(other.creationDateTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expectedResults == null) {
			if (other.expectedResults != null)
				return false;
		} else if (!expectedResults.equals(other.expectedResults))
			return false;
		if (lastTestedDateTime == null) {
			if (other.lastTestedDateTime != null)
				return false;
		} else if (!lastTestedDateTime.equals(other.lastTestedDateTime))
			return false;
		if (pass != other.pass)
			return false;
		if (testCaseID == null) {
			if (other.testCaseID != null)
				return false;
		} else if (!testCaseID.equals(other.testCaseID))
			return false;
		if (testedStatus != other.testedStatus)
			return false;
		if (testingType == null) {
			if (other.testingType != null)
				return false;
		} else if (!testingType.equals(other.testingType))
			return false;
		return true;
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
		return 0;
	}
}
