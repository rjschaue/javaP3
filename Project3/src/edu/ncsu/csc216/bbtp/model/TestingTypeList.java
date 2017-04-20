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
	private String name = "Testing Types";
	private int nextTestingTypeNum;
	private ArrayList list;
	
	public TestingTypeList() {
		list = new ArrayList();
		nextTestingTypeNum = 1;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean addTestingType(String name, String desc) {
		TestingType t = new TestingType("TT" + getNextTestingTypeNum(), name, desc);
		list.add(getNextTestingTypeNum(), t);
		t.addObserver(this);
		setChanged();
		notifyObservers(this);
		incNextTestingTypeNum();
		return true;
	}
	
	public TestingType getTestingTypeAt(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return (TestingType) list.get(index);
	}
	
	public int indexOf(String id) {
		for (int i = 0; i < list.size(); i++) {
			TestingType type = (TestingType) list.get(i);
			if (type.getTestingTypeID().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public int indexOfName(String name) {
		for (int i = 0; i < list.size(); i++) {
			TestingType type = (TestingType) list.get(i);
			if (type.getName().equals(name)) {
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
	
	private int getNextTestingTypeNum() {
		return nextTestingTypeNum;
	}
	
	private void incNextTestingTypeNum() {
		nextTestingTypeNum++;
	}
	
	@Override
	public Object[][] get2DArray() {
		Object[][] array = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			TestingType type = (TestingType) list.get(i);
			array[i][0] = type.getTestingTypeID();
			array[i][1] = type.getName();
			array[i][2] = type.getDescription();
;		}
		return array;
	}
	
	public void update(Observable o, Object arg) {
		o.notifyObservers(arg);
	}
}
