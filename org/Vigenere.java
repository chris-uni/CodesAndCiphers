package org;

public class Vigenere {

	private final int lowerCasestart = 97;
	private final int upperCaseStart = 65;
	
	private String plaintext;
	private String actualKey;
	
	private String ciphertext;
	
	public Vigenere(String plaintext, String key) {
		
		System.out.println("Vigenere cipher:");
		
		this.plaintext = plaintext;
		this.actualKey = this.setActualKey(key);
		
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
			
			// The key we will be shifting by.
			char key = actualKey.charAt(i);
			
			// Its Ascii representation.
			int asciiValue = this.getAsciiIntValue(c);
			
			// The new Ascii representation after the shift.
			int newAsciiValue = this.shift(key, asciiValue);
			
			// Adds the new Character to the word builder.
			wordBuilder += Character.toString(newAsciiValue);
		}
		
		return wordBuilder;
	}
	
	/*
	 * Converts the ascii representation of a character to its place in the alphabet.
	 * */
	private int convertToAplhabetPosition(char c) {
		
		return (int)(c % 32) - 1;
	}

	/*
	 * Checks the current characters ascii int value and shifts by three. Includes wrap-around.
	 * */
	private int shift(char c, int asciiValue) {
		
		boolean isUpper = false;
		
		if(asciiValue < 97) {
			
			isUpper = true;
		}
		
		int newAsciiValue = asciiValue + convertToAplhabetPosition(c);
		
		if(newAsciiValue > 122) {
			
			newAsciiValue = (newAsciiValue - 122) + lowerCasestart;
		}
		else if(newAsciiValue > 90 && isUpper == true) {
			
			newAsciiValue = (newAsciiValue - 91) + upperCaseStart;
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
	 * Increases the size of the provided key to the size of the provided plaintext.
	 * */
	private String setActualKey(String key) {
		
		// The actual key we will be using for the shift.
		String actualKey = key;
		
		// Length of the provided plaintext input.
		int plainLenght = plaintext.length();
		
		// Length of the provided key.
		int keyLength = key.length();
		
		// Difference betweent the two.
		int difference = plainLenght - keyLength;
		
		// If difference is bigger than 0, we know the plaintext input is longer than the provided key, therefore we need to make the key bigger.
		if(difference > 0) {
			
			for(int i = 0; i < difference; i++) {
				
				actualKey += key.charAt(i % keyLength);
			}
		}
		
		return actualKey;
	}
	
	/*
	 * Prints the ciphertext to the screen.
	 * */
	public void print() {
		
		System.out.println(plaintext + " -> " + ciphertext + "\n");
	}
}
