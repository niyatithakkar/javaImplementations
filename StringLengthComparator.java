package chapter3;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String>{
	public int xompare(String a, String b) {
		if(a.length()< b.length()) return -1;
		else if (a.length() ==b.length()) return 0;
		else return 1;
	}
}
