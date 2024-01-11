package fr.ipi.blanc.nicolas.notec;
public class main {

	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");  
	    System.out.flush();
		machine game = new machine();  
	}
}
