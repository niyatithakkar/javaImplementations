package chapter3;

import java.util.Stack;

public class ReverseArray<E> {
	public static <E> void ArrayReverse(E[] ar) {
		Stack<E> s = new ArrayStack<>(ar.length);
		for(int i=0;i<ar.length;i++) {
			s.push(ar[i]); 
		}
		for(int i=0;i<ar.length;i++) {
			ar[i] = s.pop();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] ar= {1,5,8,12,17,19,26,28,29,30,35,38,40,43,47,49,56,69,72,76,81,86,93,95,100};
		ArrayReverse(ar);
		for(int i=0;i<ar.length;i++) {
			System.out.println(ar[i]);
		}
	}

}
