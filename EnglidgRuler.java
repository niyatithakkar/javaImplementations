package chapter3;

public class EnglidgRuler {
	public static void drawLine(int len, int index){
		while(len-->0) {
			System.out.print("-");
		}
		if(index>=0) {
			System.out.print(" "+index);
		}
		System.out.println();
	}
	public static void drawLine(int len) {
		drawLine(len, -1);
	}
	public static void drawRuler(int inches, int nod) {
		drawLine(nod,0);
		for(int i=1;i<=inches;i++) {
			drawInterval(nod);
			drawLine(nod,i);
		}
		
	}
	public static void drawInterval(int nod) {
		if(nod>=1) {
			drawInterval(nod-1);
			drawLine(nod);
			drawInterval(nod-1);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		drawRuler(3,4);
	}

}
