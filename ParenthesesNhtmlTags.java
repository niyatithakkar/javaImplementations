package chapter3;

import java.util.Stack;

public class ParenthesesNhtmlTags {
	public static boolean isMatched(String ex) {
		final String op = "{[(";
		final String cl = "}])";
		Stack<Character> buffer = new SinglyLinkedStack<>();
		for(Character a: ex.toCharArray()) {
			if(op.indexOf(a)!=-1) {
				buffer.push(a);
			}
			else if(cl.indexOf(a)!=-1) {
				if(cl.isEmpty()) return false;
				if(cl.indexOf(a)!=op.indexOf(buffer.pop())) return false;
			}
		}
		return buffer.isEmpty();
	}
	public static boolean isHTMLMatched(String html) {
		Stack<String> buffer = new SinglyLinkedStack<>();
		int j = html.indexOf('<');
		while(j!=-1) {
			int k = html.indexOf('>',j+1);
			if(k==-1) return false;
			String tag = html.substring(j+1,k);
			if(!tag.startsWith("/")) {
				buffer.push(tag);
			}
			else {
				if(buffer.isEmpty()) return false;
				if(!tag.substring(1).equals(buffer.pop())) return false;
			}
			j = html.indexOf('<',k+1);
		}
		return buffer.isEmpty();
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatched("{[([{}])]}"));
		String html = "<body>\r\n"
				+ "<center>\r\n"
				+ "<h1> The Little Boat </h1>\r\n"
				+ "</center>\r\n"
				+ "<p> The storm tossed the little\r\n"
				+ "boat like a cheap sneaker in an\r\n"
				+ "old washing machine. The three\r\n"
				+ "drunken fishermen were used to\r\n"
				+ "such treatment, of course, but\r\n"
				+ "not the tree salesman, who even as\r\n"
				+ "a stowaway now felt that he\r\n"
				+ "had overpaid for the voyage. </p>\r\n"
				+ "<ol>\r\n"
				+ "<li> Will the salesman die? </li>\r\n"
				+ "<li> What color is the boat? </li>\r\n"
				+ "<li> And what about Naomi? </li>\r\n"
				+ "</ol>\r\n"
				+ "</body>";
		System.out.println(html);
		System.out.println(isHTMLMatched(html));
	}

}
