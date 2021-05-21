package chapter3;

public class sumArray {
	public static int sum(int[] ar,int n) {
		if(n==0) return 0;
		else return ar[n]+sum(ar,n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar= {1,5,8,12,17,19,26,28,29,30,35,38,40,43,47,49,56,69,72,76,81,86,93,95,100};
		System.out.println(sum(ar,ar.length-1));
	}

}
