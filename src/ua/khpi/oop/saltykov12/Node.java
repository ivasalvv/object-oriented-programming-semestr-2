package ua.khpi.oop.saltykov12;

import java.io.Serializable;

public class Node<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	E data;
	Node<E> next;

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Node() {

	}

	public Node(E element) {
		data = element;
		next = null;
	}
}