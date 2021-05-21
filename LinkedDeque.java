package chapter3;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
public class LinkedDeque<E> implements Deque<E> {
	private DoublyLinkedList<E> deque = new DoublyLinkedList<>();
	public int size() {
		return deque.size();
	}
	public boolean isEmpty() {
		return deque.size()==0;
	}
	public void addFirst(E e) {
		deque.addFirst(e);
	}
	public void addLast(E e) {
		deque.addLast(e);
	}
	public E first() {
		return deque.first();
	}
	public E last() {
		return deque.last();
	}
	public E removeFirst() {
		return deque.removeFirst();
	}
	public E removeLast() {
		return deque.removeLast();
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
