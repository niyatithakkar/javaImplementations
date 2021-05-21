package chapter3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import chapter3.Position.PositionalList;

public class LinkedPositionalList<E> implements PositionalList<E> {
	private static class Node<E> implements Position<E> {
		private E el;
		private Node<E> next;
		private Node<E> prev;
		public Node(E e, Node<E> p, Node<E> n) {
			el =e;
			next=n;
			prev = p;
		}
		public E getElement() throws IllegalStateException {
			if(next==null) throw new IllegalStateException("position no longer Valid");
			return el;
		}
		public Node<E> getNext() {
			return next;
		}
		public Node<E> getPrev(){
			return prev;
		}
		public void setNext(Node<E> n) {
			next =n;
		}
		public void setPrev(Node<E> p) {
			prev = p;
		}
		public void setElement(E e) {
			el = e;
		}
	}
	private Node<E> header;
	private Node<E> trailer;
	private int size=0;
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public LinkedPositionalList() {
		header = new Node<>(null,null,null);
		trailer = new Node<>(null,header,null);
		header.setNext(trailer);
	}
	private Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node)) throw new IllegalArgumentException("invalid p");
		Node<E> node = (Node<E>) p;
		if(node.getNext()==null) throw new IllegalArgumentException("p is no longer in the list");
		return node;
	}
	public Position<E> position(Node<E> node){
		if(node==header || node==trailer) {
			return null;
		}
		return null;
	}
	public Position<E> first(){
		return position(header.getNext());
	}
	public Position<E> last(){
		return position(trailer.getNext());
	}
	public Position<E> before(Position<E> p) throws IllegalArgumentException{
		Node<E> node =validate(p);
		return position(node.getPrev());
	}
	public Position<E> after(Position<E> cursor) throws IllegalArgumentException{
		Node<E> node =validate(cursor);
		return position(node.getNext());
	}
	public Position<E> addBetween(E e, Node<E> p, Node<E> n){
		Node<E> newest = new Node<>(e,p,n);
		p.setNext(newest);
		n.setPrev(newest);
		size++;
		return newest;
	}
	public Position<E> addFirst(E e){
		return addBetween(e,header,header.getNext());
	}
	public Position<E> addLast(E e){
		return addBetween(e,trailer.getPrev(),trailer);
	}
	public Position<E> addBefore(Position<E> p,E e) throws IllegalArgumentException{
		Node<E> newest =validate(p);
		return addBetween(e,newest.getNext(),newest);
	}
	public Position<E> addAfter(Position<E> p,E e) throws IllegalArgumentException{
		Node<E> newest =validate(p);
		return addBetween(e,newest,newest.getNext());
	}
	public E set(Position<E> p,E e) throws IllegalArgumentException{
		Node<E> newest = validate(p);
		E ans = p.getElement();
		newest.setElement(e);
		return ans;
	}
	public  E remove(Position<E> recent) {
		Node<E> newest = validate(recent);
		E ans = newest.getElement();
		newest.getPrev().setNext(newest.getNext());
		newest.getNext().setPrev(newest.getPrev());
		newest.setElement(null);
		newest.setNext(null);
		newest.setPrev(null);
		size--;
		return ans;
	}
	
	
	private class PositionalIterator<E> implements Iterator<Position<E>>, PositionalList<E>{
		private Position<E> cursor =(Position<E>) first();
		private Position<E> recent = null;
		public boolean hasNext() {
			return cursor!=null;
		}
		public Position<E> next() throws NoSuchElementException{
			if(cursor==null) throw new NoSuchElementException("no element left");
			recent =cursor;
			cursor = after(cursor);
			return recent;
		}
		public void remove() throws IllegalStateException{
			if(recent == null) throw new IllegalStateException("nothing to remove");
			LinkedPositionalList.this.remove(recent);
			recent= null;
		}
		private class PositionalIterable<E> implements Iterator<Position<E>>{
			public Iterator<Position<E>> iterator(){
				return new PositionalIterator<E>();
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Position<E> next() {
				// TODO Auto-generated method stub
				return null;
			}
		}
		public Iterable<Position<E>> positions(){
			return (Iterable<Position<E>>) new PositionalIterator();
		}
		private class ElementIterator implements Iterator<Position<E>>{
			Iterator<Position<E>> posIterator = new PositionalIterator();
			public boolean hasNext() {
				return posIterator.hasNext();
			}
			public E next() {
				return posIterator.next().getElement();
			}
			public void remove() {
				posIterator.remove();
			}
		}
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Position<E> first() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Position<E> last() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Position<E> before(Position<E> p) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Position<E> after(Position<E> p) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Position<E> addFirst(E e) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Position<E> addLast(E e) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public E set(Position<E> p, E e) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public E remove(Position<E> p) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
