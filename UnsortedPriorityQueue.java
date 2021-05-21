package chapter3;

import java.util.Comparator;

import chapter3.Position.PositionalList;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
	private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();
	public UnsortedPriorityQueue() { super();}
	public UnsortedPriorityQueue(Comparator<K> comp) { super(comp);}
	private Position<Entry<K,V>> findMin(){
		Position<Entry<K,V>> small = list.first();
		for(Position<Entry<K,V>> walk : list.positions())
			small = walk;
		return small;
	}
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
		checkKey(key);
		Entry<K,V> newest = new PQEntry<>(key,value);
		list.addLast(newest);
		return newest;
	}
	public Entry<K,V> min(){
		if(list.isEmpty()) return null;
		return findMin().getElement();
	}
	public Entry<K,V> removeMin(){
		if(list.isEmpty()) return null;
		return list.remove(findMin());
	}
	public int size() { return list.size();}
}