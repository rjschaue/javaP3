/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.util.ArrayList;

/**
 * Stores a list of testing types
 * @author Joey Schauer
 */
public class TestingTypeList extends Observable implements Tabular, Serializable, Observer {
	/** the serial version UID for TestingTypeList */
	private static final long serialVersionUID = 984509L;
	/** the name for the testing type list */
	private String name = "Testing Types";
	/** the next testing type number */
	private int nextTestingTypeNum;
	/** the array list of testing types */
	private ArrayList list;
	
	/**
	 * The constructor for TestingTypeList
	 */
	public TestingTypeList() {
		list = new ArrayList();
		nextTestingTypeNum = 1;
	}
	
	/**
	 * Returns the name of the testing type list
	 * @return the name of the testing type list
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Adds a testing type to the lsit
	 * @param name the name of the testing type
	 * @param desc the description for the testing type
	 * @return true if it was successfully added
	 */
	public boolean addTestingType(String name, String desc) {
		TestingType t = new TestingType("TT" + getNextTestingTypeNum(), name, desc);
		list.add(getNextTestingTypeNum(), t);
		t.addObserver(this);
		setChanged();
		notifyObservers(this);
		incNextTestingTypeNum();
		return true;
	}
	
	/**
	 * Returns the testing type at the given index
	 * @param index the index to gets the testing type from
	 * @return the testing type at the given index
	 * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to size
	 */
	public TestingType getTestingTypeAt(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return (TestingType) list.get(index);
	}
	
	/**
	 * Returns the index of the testing type with the given id
	 * @param id the id of the testing type to get the index of
	 * @return the index of the testing type with the given id
	 */
	public int indexOf(String id) {
		for (int i = 0; i < list.size(); i++) {
			TestingType type = (TestingType) list.get(i);
			if (type.getTestingTypeID().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the index of the testing type with the given name
	 * @param name the name of the testing type to get the index of
	 * @return the index of the testing type with the given name
	 */
	public int indexOfName(String name) {
		for (int i = 0; i < list.size(); i++) {
			TestingType type = (TestingType) list.get(i);
			if (type.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the size of the testing type list
	 * @return the size of the testing type list
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Returns true if the list is empty
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Removes the testing type at the given index from the list
	 * @param index the index to remove the testing type from
	 * @return the testing type that was removed
	 * @throws IllegalArgumentException if the index is less than 0 or greater than size
	 */
	public TestingType removeTestingTypeAt(int index) {
		if (index < 0 || index > size()) {
			throw new IllegalArgumentException();
		}
		TestingType type = (TestingType) list.remove(index);
		setChanged();
		notifyObservers(this);
		type.deleteObserver(this);
		return type;
	}
	
	/**
	 * Removes the testing type with the given id from the list
	 * @param id the if of the testing type to remove
	 * @return true if the testing type was removed
	 */
	public boolean removeTestingType(String id) {
		for (int i = 0; i < list.size(); i++) {
			TestingType type = (TestingType) list.get(i);
			if (type.getTestingTypeID().equals(id)) {
				list.remove(i);
				setChanged();
				notifyObservers(this);
				type.deleteObserver(this);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the next testing type number
	 * @return the next testing type number
	 */
	private int getNextTestingTypeNum() {
		return nextTestingTypeNum;
	}
	
	/**
	 * Increments the next testing type number
	 */
	private void incNextTestingTypeNum() {
		nextTestingTypeNum++;
	}
	
	/**
	 * Returns a 2d array of the testing type list
	 * @return a 2d array of the testing type list
	 */
	@Override
	public Object[][] get2DArray() {
		Object[][] array = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			TestingType type = (TestingType) list.get(i);
			array[i][0] = type.getTestingTypeID();
			array[i][1] = type.getName();
			array[i][2] = type.getDescription();
		}
		return array;
	}
	
	/**
	 * Updates the observers of testing type list
	 */
	public void update(Observable o, Object arg) {
		if (list.contains(o)) {
			setChanged();
			notifyObservers(arg);
		}
	}
}
