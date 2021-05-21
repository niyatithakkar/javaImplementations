package chapter3;

public class Josephus {
	public static <E> CircularQueue<E> buildQueue(E a[]){
		CircularQueue<E> queue = new LinkedCircularQueue<>();
		for(int i=0;i<a.length;i++) {
			queue.enqueue(a[i]);
		}
	}
	public static <E> E Josephus(CircularQueue<E> queue, int k) {
		if(queue.isEmpty()) return null;
		while(queue.size()>1) {
			for(int i=0;i<k-1;i++) {
				queue.rotate();
			}
			E e = queue.qeque();
			System.out.println("    "+e+" is out");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
