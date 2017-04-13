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
		//TODO complete constructor
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTestCaseListID() {
		return testCaseListID;
	}
	
	private void setTestCaseListID(String id) {
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
		TestCase t = new TestCase(testCaseListID, desc, testingType, creationDateTime, 
			expectedResults, tested, lastTestedDate, actualResults, pass);
		t.addObserver(this);
		return false;
	}
	
	public TestCase getTestCaseAt(int index) {
		return null;
	}
	
	public int indexOf(String id) {
		return 0;
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public TestCase removeTestCaseAt(int index) {
		return null;
	}
	
	public boolean removeTestCase(String id) {
		return false;
	}

	@Override
	public Object[][] get2DArray() {
		return null;
	}
	
	public void update(Observable o, Object arg) {
		//TODO implement update method
	}
}
