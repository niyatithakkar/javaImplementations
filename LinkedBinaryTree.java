package chapter3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	public static class Node<E> implements Position<E>{
		private E el;
		private Node<E> left;
		private Node<E> right;
		private Node<E> parent;
		public Node(E e,Node<E> p,Node<E> l,Node<E> r){
			el=e;
			left=l;
			parent = p;
			right=r;
		}
		public E getElement() {return el;}
		public Node<E> getParent() {return parent;}
		public Node<E> getLeft() {return left;}
		public Node<E> getRight() {return right;}
		public void setElement(E e) {el=e;}
		public void setParent(Node<E> n) { parent =n;}
		public void setLeft(Node<E> n) {left =n;}
		public void setRight(Node<E> n) {right =n;}
	}
	protected Node<E> createNode(E e,Node<E> p,Node<E> l,Node<E> r) {
		return new Node(e,p,l,r);
	}
	private int size=0;
	private Node<E> root;
	public LinkedBinaryTree() {}
	public Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node)) throw new IllegalArgumentException("Invalid Position");
		Node<E> node=(Node<E>) p;
		if(node == parent(node)) throw new IllegalArgumentException("Position no longer Exits");
		return node;
	}
	public int size() {
		return size;
	}
	public Node<E> parent(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getParent();
	}
	public Node<E> left(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getLeft();
	}
	public Node<E> right(Position<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return node.getRight();
	}
	public Node<E> addRoot(E e) throws IllegalArgumentException{
		if(!isEmpty()) throw new IllegalArgumentException("Root Already Present");
		root = createNode(e,null,null,null);
		return root;
	}
	public Node<E> addLeft(Position<E> p,E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(node.getLeft()!=null) throw new IllegalArgumentException("Left Already Present");
		Node<E> left = createNode(e,node,null,null);
		node.setLeft(left);
		size++;
		return left;
	}
	public Node<E> addRight(Position<E> p,E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(node.getRight()!=null) throw new IllegalArgumentException("Right Already Present");
		Node<E> right = createNode(e,node,null,null);
		node.setRight(right);
		size++;
		return right;
	}
	public E set(E e,Position<E> p){
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	public void attach(Position<E> p,LinkedBinaryTree t1,LinkedBinaryTree t2) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(isInternal(node)) {
			throw new IllegalArgumentException("P should be a leaf");
		}
		size+=t1.size()+t2.size();
		if(!t1.isEmpty()) {
			root.setParent(node);
			node.setLeft(root);
			t1.root = null;
			t1.size = 0;
		}
		if(!t2.isEmpty()) {
			root.setParent(node);
			node.setRight(root);
			t2.root=null;
			t2.size=0;
		}
	}
	public E remove(Position<E> p)throws IllegalArgumentException{		
		Node<E> node =validate(p);
		if(numChildren(p)==2) {
			throw new IllegalArgumentException("P has 2 Children");
		}
		Node<E> parent = node.getParent();
		Node<E> child=node.getLeft()!=null?node.getLeft():node.getRight();
		if(child!=null) {
			child.setParent(parent);
		}
		if(parent==root()) {
			root=child;
		}
		else {
			if(parent.getLeft()==node) {
				parent.setLeft(child);
			}
			else parent.setRight(child);
		}
		node.setParent(node);
		size--;
		E temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		return temp;
	}
	private void preorderSubtree(Position<E> p,List<Position<E>> snapshot) {
		snapshot.add(p);
		for(Position<E> c : children(p))
			preorderSubtree(c,snapshot);
	}
	public Iterable<Position<E>> preorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			preorderSubtree(root(),snapshot);
		return snapshot;
	}
	private void postorderSubtree(Position<E> p,List<Position<E>> snapshot) {
		for(Position<E> c : children(p))
			postorderSubtree(c,snapshot);
		snapshot.add(p);
	}
	public Iterable<Position<E>> postorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			postorderSubtree(root(),snapshot);
		return snapshot;
	}
	public Iterable<Position<E>> breadthfirst(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty()) {
			Queue<Position<E>> fringe = new LinkedList<>();
			fringe.enqueue(root());
			while(!fringe.isEmpty()) {
				Position<E> p =fringe.dequeue();
				snapshot.add(p);
				for(Position<E> c:children(p))
					fringe.enqueue(c);
			}
		}
		return snapshot;
	}
	private void inorderSubtree(Position<E> p,List<Position<E>> snapshot) {
		if(left(p) !=null) {
			inorderSubtree(left(p),snapshot);
		}
		snapshot.add(p);
		if(right(p)!=null) {
			inorderSubtree(right(p),snapshot);
		}
	}
	public Iterable<Position<E>> inorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty)
			inorderSubtree(root(),snapshot);
		return snapshot;
	}
	public Iterable<Position<E>> positions1(){
		return inorder();
	}
	public static <E> void printPreorderIndent(Tree<E> T,Position<E> p,int d) {
		System.out.println(spaces(2*d)+p.getElement());
		for(Position<E> c: T.children(p)) {
			printPreorderIndent(T,c,d+1);
		}
	}
	public static <E> void printPreorderLabeled(Tree<E> T,Position<E> p,ArrayList<Integer> path) {
		int d = path.size();
		System.out.print(spaces(d*2));
		for(int j=0;j<d;j++) System.out.print(path.get(j));
		System.out.println(p.getElement());
		path.add(1);
		for(Position<E> c: T.children(p)) {
			printPreorderLabeled(T,c,path);
			path.set(d, 1+path.get(d));
		}
	}
	public static int diskSpace(Tree<Integer> T,Position<Integer> p) {
		int subtotal = p.getElement();
		for(Position<Integer> c: T.children(p))
			subtotal+=diskSpace(T,c);
		return subtotal;
	}
	public static <E> void parenthesize(Tree<E> T,Position<E> p) {
		System.out.print(p.getElement());
		if(T.isInternal(p)) {
			boolean firstTime = true;
			for(Position<E> c : T.children(p)) {
				System.out.print(firstTime?" (":", ");
				firstTime =false;
				parenthesize(T,c);
			}
			System.out.print(")");
		}
	}
	public static <E> int layout(BinaryTree<E> T, Position<E> p,int d, int x) {
		if(T.left(p) != null) {
			x= layout(T,T.left(p),d+1,x);
		}
		p.getElement().setX(x++);
		p.getElement().setY(x++);
		if(T.right(p) !=null) {
			x=layout(T,T.right(p),d+1,x);
		}
		return x;
	}
	@Override
	public Position<E> root() {
		return root;
	}
	@Override
	public Iterable<Position<E>> positions() {
		return preorder();
	}
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext() {
			return posIterator.hasNext();
		}
		public E next(){
			return posIterator.next().getElement();
		}
		public void remove() {
			posIterator.remove();
		}
	}
	public Iterator<E> iterator(){
		return new ElementIterator();
	}
}
	