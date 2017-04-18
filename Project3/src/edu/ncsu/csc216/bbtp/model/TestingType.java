/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Observable;

/**
 * @author Joey Schauer
 */
public class TestingType extends Observable implements Serializable {
	private static final long serialVersionUID = 459188L;
	private String name;
	private String description;
	private String testingTypeID;
	
	public TestingType (String id, String name, String desc) {
		setTestingTypeID(id);
		setName(name);
		setDescription(desc);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		setChanged();
		notifyObservers(this);
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
		setChanged();
		notifyObservers(this);
	}
	
	public String getTestingTypeID() {
		return testingTypeID;
	}
	
	private void setTestingTypeID(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.testingTypeID = id;
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
		TestingType other = (TestingType) o;
		if (testingTypeID.equals(other.getTestingTypeID())) {
			return true;
		}
		return false;
	}
	
	public int compareTo(TestingType testingType) {
		return testingTypeID.compareTo(testingType.getTestingTypeID());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((testingTypeID == null) ? 0 : testingTypeID.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "TestingType [name=" + name + ", description=" + description + ", testingTypeID=" + testingTypeID + "]";
	}
}
