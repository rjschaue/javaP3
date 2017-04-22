/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.util.LinkedList;

/**
 * Stores a list of test cases
 * @author Joey Schauer
 */
public class TestCaseList extends Observable implements Tabular, Serializable, Observer {
	/** the serial version UID for TestCaseList */
	private static final long serialVersionUID = 98734509L;
	/** the name of the test case list */
	private String name;
	/** the next test case number for the test case list */
	private int nextTestCaseNum;
	/** the test case list id for the list */
	private String testCaseListID;
	/** the linked list of test cases */
	private LinkedList list;
	
	/**
	 * The constructor for TestCaseList
	 * @param name the name of the test case list
	 * @param testCaseListID the id for the test case list
	 */
	public TestCaseList(String name, String testCaseListID) {
		setName(name);
		nextTestCaseNum = 1;
		setTestCaseListID(testCaseListID);
		list = new LinkedList();
	}
	
	/**
	 * Returns the name of the test case list
	 * @return the name of the test case list
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the test case list to the given name
	 * @param name the name to set for the test case list
	 * @throws IllegalArgumentException if name is null or empty string
	 */
	public void setName(String name) {
		if (name == null || name.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * Returns the test case list id
	 * @return the test case list id
	 */
	public String getTestCaseListID() {
		return testCaseListID;
	}
	
	/**
	 * Sets the test case list id to the given string
	 * @param id the string to set the test case list id to
	 * @throws IllegalArgumentException if the id is null or empty
	 */
	private void setTestCaseListID(String id) {
		if (id == null || id.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		this.testCaseListID = id;
	}
	
	/**
	 * Returns the next test case number
	 * @return the next test case number
	 */
	private int getNextTestCaseNum() {
		return nextTestCaseNum;
	}
	
	/**
	 * Increments the next test case number
	 */
	private void incNextTestCaseNum() {
		nextTestCaseNum++;
	}
	
	/**
	 * Adds a test case to the list with the given parameters
	 * @param desc the description of the test case
	 * @param testingType the type for the test case
	 * @param creationDateTime the creatione date and time for the test case
	 * @param expectedResults the expected results of the test case
	 * @param tested true if the test case has been tested
	 * @param lastTestedDate the last tested date for the test case
	 * @param actualResults the actual results of the test case
	 * @param pass true if the test case has passed it's tests
	 * @return true if the test case is successfully added
	 */
	public boolean addTestCase(String desc, TestingType testingType, Date creationDateTime, 
			String expectedResults, boolean tested, Date lastTestedDate, String actualResults, boolean pass) {
		TestCase t;
		try {
			String testCaseID = getTestCaseListID() + "-TC" + getNextTestCaseNum();
			t = new TestCase(testCaseID, desc, testingType, creationDateTime, expectedResults, tested, lastTestedDate, actualResults, pass);
			t.addObserver(this);
			int index = 0;
			for (int i = 0; i < size(); i++) {
				TestCase newCase = (TestCase) list.get(i);
				if (t.compareTo(newCase) < 0) {
					index++;
				}
			}
			list.add(index, t);
			setChanged();
			notifyObservers(this);
			incNextTestCaseNum();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the test case at the given index
	 * @param index the index to get the test case from
	 * @return the test case at the given index
	 * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to size
	 */
	public TestCase getTestCaseAt(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return (TestCase) list.get(index);
	}
	
	/**
	 * Returns the index of the test case with the given id
	 * @param id the id of the test case to find the index of
	 * @return the index of the test case with the given id
	 */
	public int indexOf(String id) {
		if (id == null) {
			return -1;
		}
		for (int i = 0; i < list.size(); i++) {
			TestCase testCase = (TestCase) list.get(i);
			if (testCase.getTestCaseID().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the size of the test case list
	 * @return the size of the test case list
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Returns true if the test case list is empty
	 * @return true if the test case list is empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Removes the test case at the given index from the list
	 * @param index the index of the test case to remove
	 * @return the removed test case
	 * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to size
	 */
	public TestCase removeTestCaseAt(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		TestCase removed = (TestCase) list.remove(index);
		setChanged();
		notifyObservers(this);
		removed.deleteObserver(this);
		return removed;
	}
	
	/**
	 * Removes the test case with the given id
	 * @param testCaseID the id of the test case to remove
	 * @return true if the test case as removed
	 */
	public boolean removeTestCase(String testCaseID) {
		if (testCaseID == null) {
			return false;
		}
		for (int i = 0; i < size(); i++) {
			TestCase testCase = (TestCase) list.get(i);
			if (testCase.getTestCaseID().equals(testCaseID)) {
				testCase = (TestCase) list.remove(i);
				setChanged();
				notifyObservers(this);
				testCase.deleteObserver(this);
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a 2 dimensional array of the test case list
	 * @return a 2 dimensional array of the test case list
	 */
	@Override
	public Object[][] get2DArray() {
		Object[][] array;
		if (list.isEmpty()) {
			array = new Object[0][0];
			return array;
		}
		array = new Object[list.size()][9];
		for (int i = 0; i < size(); i++) {
			TestCase testCase = (TestCase) list.get(i);
			array[i][0] = testCase.getTestCaseID();
			array[i][1] = testCase.getDescription();
			array[i][2] = testCase.getTestingType();
			array[i][3] = testCase.getCreationDateTime();
			array[i][4] = testCase.getLastTestedDateTime();
			array[i][5] = testCase.tested();
			array[i][6] = testCase.getExpectedResults();
			array[i][7] = testCase.getActualResults();
			array[i][8] = testCase.pass();
		}
		return array;
	}
	
	/**
	 * Updates the observers for test case list
	 * @param o is the observable to update
	 * @param arg is the object to send over
	 */
	public void update(Observable o, Object arg) {
		if (list.contains(o)) {
			setChanged();
			notifyObservers(arg);
		}
	}
}
