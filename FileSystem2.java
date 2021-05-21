package chapter3;

import java.io.File;

public class FileSystem2 {
	public static long diskUsage(File root) {
		long total = root.length();
		if(root.isDirectory()) {
			for(String ch : root.list()) {
				File child = new File(root, ch);
				total += child.length();
			}
		}
		System.out.println(total+"\t"+ root);
		return total;
	}
}
