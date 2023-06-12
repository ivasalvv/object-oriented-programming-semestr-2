package ua.khpi.oop.saltykov09;

import java.io.Serializable;
import java.util.Objects;

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
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    
	    @SuppressWarnings("unchecked")
		Node<E> other = (Node<E>) obj;
	    // Compare fields for equality
	    return this.data.equals(other.data) && this.next.equals(other.next);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(data, next);
	}
}