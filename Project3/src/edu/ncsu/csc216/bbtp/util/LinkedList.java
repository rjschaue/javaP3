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
	/** serial version UID for LinkedList */
	private static final long serialVersionUID = 349987L;
	/** the head node for the linked list */
	private Node head;

	/**
	 * The null constructor for LinkedList
	 */
	public LinkedList() {
		head = null;
	}
	
	/**
	 * Returns the size of the linked list
	 * @return the size of the linked list
	 */
	@Override
	public int size() {
		int size = 0;
		for (Node p = head; p != null; p = p.next) {
			size++;
		}
		return size;
	}

	/**
	 * Returns true if the linked list is empty
	 * @return true if the linked list is empty
	 */
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Returns true if the linked list contains the object
	 * @param o is the object to check for in the linked list
	 * @return true if the linked list contains the object
	 */
	@Override
	public boolean contains(Object o) {
		if (o == null) {
			return false;
		}
		for (Node p = head; p != null; p = p.next) {
			if (p.value.equals(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds the given object to the linked list
	 * @param o is the object to add to the linked list
	 * @return true if the object is successfully added to the linked list
	 */
	@Override
	public boolean add(Object o) {
		if (o == null) {
			throw new NullPointerException();
		}
		Node newNode = new Node(o, null);
		if (head == null) {
			head = newNode;
			return true;
		}
		Node current = head;
		for (Node p = head; p != null; p = p.next) {
			current = p;
		}
		current.next = newNode;
		return true;
	}

	/**
	 * Returns the object at the given index in the linked list
	 * @param index is the index to get the object from
	 * @return the object at the given index in the linked list
	 * @throws new IndexOutOfBoundsException if the index is less than 0 or greater than or equal to size
	 */
	@Override
	public Object get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node current = head;
		
		while (current != null && index > 0) {
			current = current.next;
			index--;
		}
		if (current == null) {
			return null;
		}
		return current.value;
	}

	/**
	 * Adds the given element to the linked list at the given index
	 * @param index is the index to add the element at
	 * @param element is the element to add to the linked list
	 * @throws NullPointerException if the element is null
	 * @throws IllegalArgumentException if the element is already in the list
	 * @throws IndexOutOfBoundsException is the index is less than 0 or greater than size
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
		if (index == 0) {
			head = new Node(element, head);
		} else {
			Node current = head;
			while (current != null && index > 1) {
				current = current.next;
				index--;
			}
			if (current != null) {
				if (current.next != null) {
					current.next = new Node(element, current.next);
				} else {
					current.next = new Node(element, null);
				}
			} 
		}	
	}

	/**
	 * Removes the element at the given index from the linked list
	 * @param index is the index to remove the element from
	 * @return the object that was removed
	 * @throws IndexOutOfBoundsException if the index is less than 0 or greater than or equal to size
	 */
	@Override
	public Object remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}		
		Node current = head;
		Node previous = null;		
		while (current != null && index > 0) {
			previous = current;
			current = current.next;
			index--;
		}		
		if (current != null) {
			if (current == head) {
				head = head.next;
			} else {
				previous.next = current.next;
			}
			return current.value;
		}		
		return null;
	}

	/**
	 * Returns the index of the given object
	 * @return the index of the given object or -1 if it isn't in the list
	 */
	@Override
	public int indexOf(Object o) {
		if (o == null) {
			return -1;
		}
		int index = 0;
		for (Node p = head; p != null; p = p.next) {
			if (p.value.equals(o)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	/**
	 * Contains an Object and a reference to the next Node in the List
	 * @author Joey Schauer
	 */
	private class Node implements Serializable{
		/** the serial version UID for Node */
		private static final long serialVersionUID = 484909840L;
		/** the object value for the Node */
		Object value;
		/** the next Node in the link */
		Node next;
		
		/**
		 * The null constructor for Node
		 * @param value the object in the node
		 * @param next the next Node in the link
		 */
		public Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
}
