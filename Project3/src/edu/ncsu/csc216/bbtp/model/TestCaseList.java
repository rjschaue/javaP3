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
 * @author Joey Schauer
 */
public class TestCaseList extends Observable implements Tabular, Serializable, Observer {
	private static final long serialVersionUID = 98734509L;
	private String name;
	private int nextTestCaseNum;
	private String testCaseListID;
	private LinkedList list;
	
	public TestCaseList(String name, String TestCaseListID) {
		setName(name);
		nextTestCaseNum = 1;
		setTestCaseListID(TestCaseListID);
		list = new LinkedList();
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
	
	public String getTestCaseListID() {
		return testCaseListID;
	}
	
	private void setTestCaseListID(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.testCaseListID = id;
	}
	
	private int getNextTestCaseNum() {
		return nextTestCaseNum;
	}
	
	private void incNextTestCaseNum() {
		nextTestCaseNum++;
	}
	
	public boolean addTestCase(String desc, TestingType testingType, Date creationDateTime, 
			String expectedResults, boolean tested, Date lastTestedDate, String actualResults, boolean pass) {
		TestCase t;
		try {
			String testCaseID = getTestCaseListID() + "-TC" + getNextTestCaseNum();
			t = new TestCase(testCaseID, desc, testingType, creationDateTime, expectedResults, tested, lastTestedDate, actualResults, pass);
			t.addObserver(this);
			if (lastTestedDate == null) {
				list.add(t);
			} else {
				for (int i = 0; i < size(); i++) {
					TestCase newCase = (TestCase) list.get(i);
					if (newCase.getLastTestedDateTime() != null) {
						if (t.getLastTestedDateTime().before(newCase.getLastTestedDateTime())) {
							list.add(i, t);
							break;
						}
					}
				}
			}
			setChanged();
			notifyObservers(this);
			incNextTestCaseNum();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public TestCase getTestCaseAt(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return (TestCase) list.get(index);
	}
	
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
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
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
	
	public boolean removeTestCase(String TestCaseID) {
		if (TestCaseID == null) {
			return false;
		}
		for (int i = 0; i < size(); i++) {
			TestCase testCase = (TestCase) list.get(i);
			if (testCase.getTestCaseID().equals(TestCaseID)) {
				testCase = (TestCase) list.remove(i);
				setChanged();
				notifyObservers(this);
				testCase.deleteObserver(this);
				return true;
			}
		}
		return false;
	}

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
	
	public void update(Observable o, Object arg) {
		o.notifyObservers(arg);
	}
}
