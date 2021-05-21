package chapter3;

import java.util.Queue;

public class ArrayQueue<E> implements Queue<E> {
	private E[] Q;
	public ArrayQueue() {
		this(1000);
	}
	public ArrayQueue(int capacity){
		Q = (E[]) new Object[capacity];
	}
	private	int sz=0;
	private int f=0;
	public int size() {
		return sz;
	}
	public boolean isEmpty() {
		return sz==0;
	}
	public E enqueue(E e) throws IllegalStateException{
		if(sz==Q.length) throw new IllegalStateException("Queue is Full");
		Q[(f+sz)%Q.length] = e;
		sz++;
		return e;
	}
	public E first() {
		if(isEmpty()) return null;
		return Q[f];
	}
	public E dequeue() {
		if(isEmpty()) return null;
		E ans = Q[f];
		Q[f]=null;
		f= (f+1)%Q.length;
		sz--;
		return ans;
	}
	
}
