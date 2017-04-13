/**
 * 
 */
package edu.ncsu.csc216.bbtp.util;

import java.io.Serializable;

/**
 * An implementation of the List interface with a data structure of linked Nodes
 * @author Joey Schauer
 */
public class LinkedList implements List, Serializable {
	private static final long serialVersionUID = 349987L;
	private Node head;

	public LinkedList() {
		
	}
	
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
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

	/**
	 * Contains an Object and a reference to the next Node in the List
	 * @author Joey Schauer
	 */
	private class Node implements Serializable{
		private static final long serialVersionUID = 484909840L;
		Object value;
		Node next;
		
		public Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
}
