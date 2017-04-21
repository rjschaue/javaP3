/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Observable;

/**
 * Stores values for testing types and allows setting and getting of those values
 * @author Joey Schauer
 */
public class TestingType extends Observable implements Serializable {
	/** the serial version UID for TestingType */
	private static final long serialVersionUID = 459188L;
	/** the name of the testing type */
	private String name;
	/** the description of the testing type */
	private String description;
	/** the id for the testing type */
	private String testingTypeID;
	
	/**
	 * The constructor for TestingType
	 * @param id the id for the testing type
	 * @param name the name of the testing type
	 * @param desc the description of the testing type
	 */
	public TestingType (String id, String name, String desc) {
		setTestingTypeID(id);
		setName(name);
		setDescription(desc);
	}
	
	/**
	 * Returns the name of the testing type
	 * @return the name of the testing type
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the testing type name to the given string
	 * @param name the name to set the testing type to
	 * @throws IllegalArgumentException if name is null or an empty string
	 */
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * Returns the description of the testing type
	 * @return the description of the testing type
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the testing type description to the given string
	 * @param desc the string to set the testing type description to
	 */
	public void setDescription(String desc) {
		this.description = desc;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * Returns the testing type id for the testing type
	 * @return the testing type id for the testing type
	 */
	public String getTestingTypeID() {
		return testingTypeID;
	}
	
	/**
	 * Sets the testing type id to the given string
	 * @param id the id to set the testing type id to
	 * @throws IllegalArgumentException if the id is null or an empty string
	 */
	private void setTestingTypeID(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.testingTypeID = id;
		setChanged();
		notifyObservers(this);
	}

	/**
	 * Determines if two testing types are equal by their id
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		TestingType other = (TestingType) o;
		if (testingTypeID.equals(other.getTestingTypeID())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Compares two testing types by their id
	 * @param testingType the testing type to compare against
	 * @return an integer value for less than 0 (before) 0 (equal) or greater than 0 (after)
	 */
	public int compareTo(TestingType testingType) {
		return testingTypeID.compareTo(testingType.getTestingTypeID());
	}
	
	/**
	 * Generates hash code for the testing type
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((testingTypeID == null) ? 0 : testingTypeID.hashCode());
		return result;
	}

	/**
	 * Returns a string representation of the testing type
	 */
	@Override
	public String toString() {
		return "TestingType [name=" + name + ", description=" + description + ", testingTypeID=" + testingTypeID + "]";
	}
}
