package ua.khpi.oop.saltykov09;

import java.io.Serializable;
import java.util.Iterator;

public class CustomLinkedList<E> implements Iterable<E>, Serializable {

	private static final long serialVersionUID = 1L;
	Node<E> head;

	public CustomLinkedList() {

	}

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public void insert(E data) {

		Node<E> new_node = new Node<>(data);

		if (this.head == null) {
			this.head = new_node;
		} else {

			Node<E> last = this.head;
			while (last.next != null) {
				last = last.next;
			}

			last.next = new_node;
		}
	}

	public void printList(CustomLinkedList<E> list) {
		Node<E> currNode = list.head;

		System.out.print("LinkedList: ");

		while (currNode != null) {

			System.out.print(currNode.data + " ");

			currNode = currNode.next;
		}

		System.out.println();
	}

	public void deleteAtPosition(int index) {
		Node<E> currNode = this.head, prev = null;

		if (index == 0 && currNode != null) {
			this.head = currNode.next;

			System.out.println(index + " position element deleted");

			return;
		}

		int counter = 0;

		while (currNode != null) {

			if (counter == index) {

				prev.next = currNode.next;

				System.out.println(index + " position element deleted");
				break;
			} else {

				prev = currNode;
				currNode = currNode.next;
				counter++;
			}
		}

		if (currNode == null) {

			System.out.println(index + " position element not found");
		}
	}

	public void insertAtPosition(int index, E data) {
		Node<E> currNode = this.head, prev = null;
		if (currNode == null) {
			this.insert(data);
			return;
		}
		int counter = 0;
		Node<E> new_node = new Node<>(data);

		if (index == 0 && currNode != null) {
			new_node.next = this.head;
			this.head = new_node;
			return;
		} else {
			prev = currNode;
			currNode = currNode.next;
			counter++;
		}
		while (currNode != null) {
			if (counter == index) {
				new_node.next = currNode;
				prev.next = new_node;
				break;
			} else {
				prev = currNode;
				currNode = currNode.next;
				counter++;
			}
		}
		if (currNode == null) {
			this.insert(data);
		}
	}

	public void clear() {
		this.head = null;
	}

	public int size() {
		int count = 0;
		Node<E> currNode = this.head;
		while (currNode != null) {
			currNode = currNode.next;
			count++;
		}
		return count;
	}
	
	

	public Object[] toArray() {
		Node<E> currNode = this.head;
		Object[] array = new Object[this.size()];

		for (int i = 0; i < this.size(); i++) {
			array[i] = currNode.data;
			currNode = currNode.next;
		}
		return array;
	}

	public boolean isExist(CustomLinkedList<E> list, E element) {
		if (list.head == null)
			return false;
		Node<E> currNode = list.head;
		while (currNode != null) {
			if (currNode.data == element)
				return true;
			currNode = currNode.next;
		}
		return false;
	}

	public String toString() {
		Node<E> currNode = this.head;
		String output = new String();
		while (currNode != null) {
			output = output.concat(currNode.data.toString() + System.lineSeparator());
			currNode = currNode.next;
		}
		return output;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new SimpleArrayIterator();
	}

	private class SimpleArrayIterator implements Iterator<E> {

		Node<E> currNode = CustomLinkedList.this.head;

		@Override
		public boolean hasNext() {
			if (currNode.next == null)
				return false;
			return true;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			E redata = currNode.data;
			currNode = currNode.next;
			return redata;
		}

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
