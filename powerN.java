package chapter3;

public class powerN {
	public static double power1(int x,int n) {
		if(n==0)return 1;
		else return x*power1(x,n-1);
	}
	public static double power2(int x, int n) {
		if(n==0) return 1;
		else {
			double ans = power2(x,n/2);
			double result = ans*ans;
			if(n%2==1) {
				result*=x;
			}
			return result;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power2(2,5));

	}

}
