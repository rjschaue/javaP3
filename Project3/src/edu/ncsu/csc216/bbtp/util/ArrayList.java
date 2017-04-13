/**
 * 
 */
package edu.ncsu.csc216.bbtp.util;

import java.io.Serializable;

/**
 * An implementation of the List interface with an array data structure
 * @author Joey Schauer
 */
public class ArrayList implements List, Serializable {
	private static final long serialVersionUID = 28592L;
	private static final int RESIZE = 0;
	private Object[] list;
	private int size;

	public ArrayList() {
		//TODO implement null constructor
	}
	
	public ArrayList(int size) {
		//TODO implement constructor with size
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean add(Object o) {
		return false;
	}

	@Override
	public Object get(int index) {
		return null;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub		
	}

	@Override
	public Object remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

}
