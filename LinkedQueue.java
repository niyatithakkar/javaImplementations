package chapter3;

import java.util.Queue;

public class LinkedQueue<E> implements Queue<E>{
	public LinkedQueue() {}
	private SinglyLinkedList<E> Q = new SinglyLinkedList<>();
	private int sz=0;
	public int size() {
		return sz;
	}
	public boolean isEmpty() {
		return sz==0;
	}
	public E first() {
		if(isEmpty()) return null;
		return Q.first();
	}
	public void enqueue(E e) {
		Q.addLast(e);
	}
	public E dequeue() {
		return Q.removeFirst();
	}
}

