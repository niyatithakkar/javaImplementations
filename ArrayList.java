package chapter3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	private E[] data;
	private static int CAP= 16;
	private int size=0;
	public int size() {
		return size();
	}
	public boolean isEmpty() {
		return size==0;
	}
	public ArrayList() {
		this(CAP);
	}
	public ArrayList(int cap) {
		data= (E[]) new Object[cap];
	}
	public void check(int i,int n) throws IndexOutOfBoundsException {
		if(i<0 || i>=size) {
			throw new IndexOutOfBoundsException("Invalid Index "+i);
		}
	}
	public E get(int i) throws IndexOutOfBoundsException {
		check(i,size);
		return data[i];
	}
	public E set(E e,int i) throws IndexOutOfBoundsException{
		check(i,size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}
	public void add(E e,int i) throws IndexOutOfBoundsException {
		check(i,size+1);
		if(size==data.length) resize(2*size);
		for(int j=size-1;j>=i;j--) {
			data[j+1] = data[j];
		}
		data[i]=e;
		size++;
	}
	public E remove(int i) {
		check(i,size);
		E temp = data[i];
		for(int j=i;j<size-1;j++) {
			data[i]=data[i+1];
		}
		data[size-1]=null;
		size--;
		if(size ==data.length/4) resize(data.length/2);
		return temp;
	}
	public void resize(int len) {
		E[] temp = (E[]) new Object[len];
		for(int i =0;i<data.length;i++) {
			temp[i]=data[i];
		}
		data =temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public boolean add(E arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void add(int arg0, E arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object arg0) {
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
	public E set(int arg0, E arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
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
	
	
	
	private class ArrayIterator<E> implements Iterator<E> {
		private int j=0;
		private boolean removable =false;
		@Override
		public boolean hasNext() {
			return j<size;
		}

		@Override
		public E next() throws NoSuchElementException{
			if(j==size) throw new NoSuchElementException("No next Element");
			removable = true;
			return (E) data[j++];
		}
		public void remove() throws IllegalStateException{
			if(!removable) throw new IllegalStateException("nothing to remove");
			ArrayList.this.remove(j-1);
			j--;
			removable=false;
		}
		public Iterator<E> iterator(){
			return new ArrayIterator();
		}

	}


}

