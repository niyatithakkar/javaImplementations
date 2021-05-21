package chapter3;

import java.util.Stack;

public class SinglyLinkedStack<E> extends Stack<E> {
	private SinglyLinkedList<E> s = new SinglyLinkedList<>();
	public SinglyLinkedStack() {
	}
	public int size() {
		return s.size();
	}
	public boolean isEmpty(){
		return s.isEmpty();
	}
	public E push(E e) {
		s.addFirst(e);
		return e;
	}
	public E pop(){
		return s.removeFirst();
	}
	
	public E top() {
		return s.first();
	}
	
}
