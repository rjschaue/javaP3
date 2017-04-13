/**
 * 
 */
package edu.ncsu.csc216.bbtp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.model.TestCaseList;
import edu.ncsu.csc216.bbtp.model.TestingTypeList;

/**
 * @author Joey Schauer
 */
public class BBTP extends Observable implements Serializable, Observer {
	private static final long serialVersionUID = 34992L;
	private static final int RESIZE = 0;
	private int numLists;
	private String filename;
	private boolean changed;
	private int nextTestCaseListNum;
	private ArrayList<TestCaseList> testCases;
	private TestingTypeList testingTypes;
	
	public BBTP() {
		//TODO implement constructor
	}
	
	public boolean isChanged() {
		return changed;
	}
	
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	private int getNextTestCaseListNum() {
		return nextTestCaseListNum;
	}
	
	private void incNextTestCaseListNum() {
		nextTestCaseListNum++;
	}
	
	public int getNumTestCaseLists() {
		return numLists;
	}
	
	public TestCaseList getTestCaseList(int index) {
		return testCases.get(index);
	}
	
	public TestingTypeList getTestingTypeList() {
		return testingTypes;
	}
	
	public int addTestCaseList() {
		
		return 0;
	}
	
	public void removeTestCaseList(int index) {
		//TODO implement remove test case list
	}
	
	public boolean saveDataFile(String filename) {
		return false;
	}
	
	public boolean openDataFile(String filename) {
		return false;
	}
	
	public void update(Observable o, Object arg) {
		//TODO implement update
	}
}
