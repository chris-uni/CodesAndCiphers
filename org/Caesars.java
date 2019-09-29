package org;

public class Caesars {

	private final int lowerCasestart = 97;
	private final int upperCaseStart = 65;
	
	private String plaintext;
	private String ciphertext;
	
	private int offset = 23;
	
	public Caesars(String plaintext) {
		
		System.out.println("Caesars Shift:");
		
		this.plaintext = plaintext;
		
		this.ciphertext = this.getChars();
	}
	
	/*
	 * Iterates through a word, gets each character and shifts it up the alphabet by 3.
	 * */
	private String getChars() {
		
		String wordBuilder = "";
		
		for(int i = 0; i < plaintext.length(); i++) {
			
			// The current character in the word.
			char c = plaintext.charAt(i);
			
			// Its Ascii representation.
			int asciiValue = this.getAsciiIntValue(c);
			
			// The new Ascii representation after the shift.
			int newAsciiValue = this.shift(asciiValue);
			
			// Adds the new Character to the word builder.
			wordBuilder += this.asciiToChar(newAsciiValue);
		}
		
		return wordBuilder;
	}
	
	/*
	 * Converts an int into its ascii representation (a character)
	 * */
	private char asciiToChar(int ascii) {
		
		return (char)ascii;
	}
	
	/*
	 * Checks the current characters ascii int value and shifts by three. Includes wrap-around.
	 * */
	private int shift(int asciiValue) {
		
		int newAsciiValue = asciiValue + offset;
		
		if(newAsciiValue > 122) {
			
			newAsciiValue = (newAsciiValue - 122) + lowerCasestart;
		}
		else if(newAsciiValue > 90 && newAsciiValue < lowerCasestart) {
			
			newAsciiValue = (newAsciiValue - 90) + upperCaseStart;
		}
		
		return newAsciiValue;
	}
	
	/*
	 * Converts a character to its ascii int value.
	 * */
	private int getAsciiIntValue(char c) {
		
		return (int)c;
	}
	
	/*
	 * Prints the final ciphertext to the console.
	 * */
	public void print() {
		
		System.out.println(plaintext + " -> " + ciphertext + "\n");
	}
}
