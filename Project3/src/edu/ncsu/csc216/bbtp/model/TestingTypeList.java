/**
 * 
 */
package edu.ncsu.csc216.bbtp.model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.ncsu.csc216.bbtp.util.ArrayList;

/**
 * @author Joey Schauer
 */
public class TestingTypeList extends Observable implements Tabular, Serializable, Observer {
	private static final long serialVersionUID = 984509L;
	private String name;
	private int nextTestingTypeNum;
	private ArrayList list;
	
	public TestingTypeList() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public boolean addTestingType(String name, String desc) {
		TestingType t = new TestingType("TT" + nextTestingTypeNum, name, desc);
		t.addObserver(this);
		return false;
	}
	
	public TestingType getTestingTypeAt(int index) {
		return null;
	}
	
	public int indexOf(String id) {
		return 0;
	}
	
	public int indexOfName(String name) {
		return 0;
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public TestingType removeTestingTypeAt(int index) {
		return null;
	}
	
	public boolean removeTestingType(String id) {
		return false;
	}
	
	private int getNextTestingTypeNum() {
		return nextTestingTypeNum;
	}
	
	private void incNextTestingTypeNum() {
		
	}
	
	@Override
	public Object[][] get2DArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void update(Observable o, Object arg) {
		
	}
}
