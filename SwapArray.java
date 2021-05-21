package chapter3;

public class SwapArray {
	public static int[] swap(int[] a,int h,int l) {
		if(l>h) return a;
		else {
			int temp = a[h];
			a[h] =a[l];
			a[l]=temp;
			return swap(a,h-1,l+1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] = {1,5,8,12,17,19,26,28,29,30,35,38,40,43,47,49,56,69,72,76,81,86,93,95,100};
		ar = swap(ar,ar.length-1,0);
		int n =ar.length;
		while(--n>=0) {
			System.out.print(ar[n]+" ");
		}
	}

}
