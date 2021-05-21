package chapter3;

public class GameEntry {
	private String name;
	private int score;
	public GameEntry(String n, int s) {
		name =n;
		score =s;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public String toString() {
		return "("+name+", "+score+")";
	}
	public static void main(String[] args) {
		GameEntry g = new GameEntry("Bell",2);
		GameEntry f = new GameEntry("Allie",4);
		Scoreboard s = new Scoreboard(2);
		s.add(g);
		s.add(f);
		System.out.println(g.toString());
		
	}
	
}

