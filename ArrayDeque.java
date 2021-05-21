package chapter3;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class ArrayDeque<E> implements Deque<E> {
	private int f=-1,l=0;
	private E[] deque;
	private int size=0;
	public ArrayDeque() {
		this(1000);
	}
	public ArrayDeque(int capacity) {
		deque = (E[]) new Object[capacity];
	}
	public int size() {
		return size();
	}
	public boolean isEmpty() {
		return size==0;
	}
	public E first() {
		return deque[f];
	}
	public E last() {
		return deque[l];
	}
	public void addFirst(E e) throws IllegalStateException {
		if(size==deque.length) throw new IllegalStateException("Deque is Full");
		if(f==0) f=deque.length-1;
		else f=f-1;
		deque[f]=e;
		size++;
	}
	public void addLast(E e) throws IllegalStateException  {
		if(size==deque.length) throw new IllegalStateException("Deque is Full");
		if(l==deque.length-1) l=0;
		else l=l+1;
		deque[l]=e;
		size++;
	}
	public E removeFirst() {
		if(isEmpty()) return null;
		E ans = deque[f];
		deque[f]=null;
		if(size==1) {
			f=l=-1;
		}
		else if(f==deque.length-1) {
			f=0;
		}
		else f=f+1;
		size--;
		return ans;
	}
	public E removeLast() {
		if(isEmpty()) return null;
		E ans=deque[l];
		deque[l]=null;
		if(size==1) {
			f=l=-1;
		}
		else if(l==0) {
			l=deque.length-1;
		}
		else l=l-1;
		size--;
		return ans;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean offerFirst(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean offerLast(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E peekFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E peekLast() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E pollLast() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeFirstOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	public static void main(String[] args) {
		LinkedDeque<Integer> d = new LinkedDeque<>();
		d.addFirst(9);
		d.addFirst(6);
		d.addLast(8);
		d.addFirst(0);
		d.addLast(1);
		d.addLast(7);
		System.out.println(d.removeLast());
		System.out.println(d.removeFirst());
		System.out.println(d.removeFirst());
		System.out.println(d.removeFirst());
		System.out.println(d.removeLast());
		System.out.println(d.removeLast());
		
	}
}