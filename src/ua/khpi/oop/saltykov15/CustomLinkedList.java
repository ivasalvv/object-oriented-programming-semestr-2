package ua.khpi.oop.saltykov15;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomLinkedList<E> implements Iterable<E>, Serializable {
	
	private static final long serialVersionUID = 1L;
	LinkedList<E> list;
	
	public CustomLinkedList() {
	this.list = new LinkedList<E>();
	}

	public LinkedList<E> getLinkedList() {
		return list;
	}

	public void setLinkedList(LinkedList<E> list) {
		this.list = list;
	}

	public void insert(E data) {
		list.add(data);
	}

	public void deleteAtPosition(int index) {
	this.list.remove(index);
	}

	public void insertAtPosition(int index, E data) {
	this.list.add(index, data);
	}

	public void clear() {
		this.list = null;
		this.list = new LinkedList<E>();
	}

	public int size() {
		return this.list.size();
	}

//============
    public void sortList(Comparator<E> comperator) {
    this.list.sort(comperator);
    }

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return this.list.descendingIterator();
	}

//
//	public static void main(String[] args) {
//		CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
//		list.insert(1);
//		list.insert(2);
//		list.insert(3);
//		list.insert(4);
//		list.insert(5);
//		list.insert(6);
//		list.insert(7);
//		list.insert(8);
//		list.printList(list);
//		list.deleteAtPosition(0);
//		list.printList(list);
//		list.deleteAtPosition(2);
//		list.printList(list);
//		list.deleteAtPosition(10);
//		list.printList(list);
//		list.insertAtPosition(1, 11);
//		list.printList(list);
//		System.out.println(list.size());
//		Object[] Array1 = list.toArray();
//		list.printList(list);
//		System.out.println(Arrays.toString(Array1));
//		System.out.println(list.isExist(list, 11));
//		list.printList(list);
//		for (Object i : list) {
//			System.out.println((Integer) i);
//		}
//	}
}
