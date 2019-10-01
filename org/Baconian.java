package org;

import java.math.BigInteger;

public class Baconian {

	private String plaintext;
	
	private String ciphertext;
	
	public Baconian(String plaintext) {
		
		System.out.println("Baconian cipher: ");
		
		this.plaintext = plaintext;
		
		this.sub();
	}
	
	/*
	 * Goes over each letter in plaintext word, words out place in alphabet, converts that number (place) to binary, then swapps the 0's and 1's to a's 
	 * and b's respectfully.
	 * */
	private void sub() {
		
		String stringBuilder = "";
		
		for(int i = 0; i < this.plaintext.length(); i++) {
			
			char c = Character.toUpperCase(this.plaintext.charAt(i));
			int charPos = (int)c % 65;
			
			String charBin = this.toBinary(charPos);
			
			stringBuilder += this.convertBinary(charBin);
		}
		
		this.ciphertext = stringBuilder;
	}
	
	/*
	 * Converts a number to its binary representation (string).
	 * */
	private String toBinary(int number) {
		
		return String.format("%05d", new BigInteger(Integer.toBinaryString(number)));
	}
	
	/*
	 * Based on the inputs position in the alphabet, this method will build its ab binary representation.
	 * */
	private String convertBinary(String binary) {
		
		String builder = "";
		
		for(int i = 0; i < binary.length(); i++) {
			
			char c = binary.charAt(i);
			
			if(c == '0') {
				
				builder += "a";
			}
			else {
				builder += "b";
			}
		}
		
		return builder;
	}
	
	/*
	 * Prints out the ciphertext to the console.
	 * */
	public void print() {
		
		System.out.println(this.plaintext + " -> " + this.ciphertext + "\n");
	}
}
