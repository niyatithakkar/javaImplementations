package chapter3;

public interface PriorityQueue<K,V> {
	int size();
	boolean isEmpty();
	Entry<K,V> insert(K key, V value) throws IllegalAccessException;
	Entry<K,V> min();
	Entry<K,V> removeMin();
}
