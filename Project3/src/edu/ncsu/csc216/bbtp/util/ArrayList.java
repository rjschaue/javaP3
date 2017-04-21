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
	/** serial version UID for ArrayList */
	private static final long serialVersionUID = 28592L;
	/** the constant resize value for ArrayList */
	private static final int RESIZE = 10;
	/** the list to get objects for the ArrayList */
	private Object[] list;
	/** the size of the ArrayList */
	private int size;

	/**
	 * The null constructor for ArrayList
	 */
	public ArrayList() {
		list = new Object[RESIZE];
		size = 0;
	}
	
	/**
	 * The constructor for ArrayList that takes a size parameter
	 * @param size the capacity for the ArrayList
	 * @throws IllegalArgumentException if the size is negative
	 */
	public ArrayList(int size) {
		if (size < 0) {
			throw new IllegalArgumentException();
		}
		list = new Object[size];
		size = 0;
	}
	
	/**
	 * Returns the size of the array
	 * @return the size of the array
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if the array is empty
	 * @return true if the array is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns true if the array contains the given object
	 * @param o is the object to check for
	 * @return true if the array contains the given object
	 */
	@Override
	public boolean contains(Object o) {
		if (o == null) {
			return false;
		}
		for (int i = 0; i < size(); i++) {
			if (get(i).equals(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds the given object to the array
	 * @param is the object to add
	 * @return true if the object is successfully added
	 */
	@Override
	public boolean add(Object o) {
		if (o == null) {
			return false;
		}
		if (contains(o)) {
			return false;
		}
		list[size] = o;
		size++;
		if (size == list.length) {
			growArray();
		}
		return true;
	}

	/**
	 * Gets the object at the given index
	 * @param index is the index to get the object from
	 * @return the object at the given index
	 * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to size
	 */
	@Override
	public Object get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return list[index];
	}

	/**
	 * Adds a given object at the given index
	 * @param index the index to add the object to
	 * @param element is the object to add to the array
	 * @throws NullPointerException if the element is null
	 * @throws IllegalArgumentException if the element is already in the list
	 * @throws IndexOutOfBoundsException if the index is less than 0 or greater than size
	 */
	@Override
	public void add(int index, Object element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (contains(element)) {
			throw new IllegalArgumentException();
		}
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		for (int k = size; k > index; k--) {
			list[k] = list[k - 1];
		}
		list[index] = element;
		size++;
		if (size == list.length) {
			growArray();
		}	
	}

	/**
	 * Removes the object at the given index in the list
	 * @param index is the index of the object to remove
	 * @return the object that was removed
	 * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to size
	 */
	@Override
	public Object remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Object element = list[index];
		for (int i = index; i < size; i++) {
			list[i] = list[i + 1];
		}
		list[size] = null;
		size--;
		return element;
	}

	/**
	 * Returns the index of the given object in the list
	 * @return the index of the given object in the list or -1 if it isn't in the list
	 */
	@Override
	public int indexOf(Object o) {
		if (o == null) {
			return -1;
		}
		for (int i = 0; i < size; i++) {
			if (list[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Private method to grow the array when needed
	 */
	private void growArray() {
		int newSize = size + RESIZE;
		Object[] newList = new Object[newSize];
		for (int i = 0; i < size(); i++) {
			newList[i] = list[i];
		}
		list = newList;
	}
}
