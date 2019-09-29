package org;

public class Main {

	public static void main(String[] args) {
		
		Caesars caesars = new Caesars("ATTACKATDAWN");
		caesars.print();
		
		Vigenere vigenere = new Vigenere("ATTACKATDAWN", "LEMON");
		vigenere.print();
		
		RailFence railfence = new RailFence("ATTACKATDAWN", 4);
		railfence.print();
	}
}
