package org;

import java.util.ArrayList;

public class RailFence {

	private String plaintext;
	private int key;
	
	private String ciphertext;
	
	private ArrayList<ArrayList<String>> rails;
	
	public RailFence(String plaintext, int key) {
		
		System.out.println("Rail Fence:");
		
		this.plaintext = plaintext;
		this.key = key;
		
		rails = new ArrayList<ArrayList<String>>(key);
		this.initRails(key);
		
		this.splitChars();
		
		this.joinRails();
	}
	
	/*
	 * Makes sure that all the rails are initialised before we add characters to them.
	 * */
	private void initRails(int key) {
		
		for(int i = 0; i < key; i++) {
			
			ArrayList<String> r = new ArrayList<String>();
			this.rails.add(r);
		}
	}
	
	/*
	 * Will split out the word onto their corresponding rails.
	 * */
	private void splitChars() {
		
		int counter = 0;
		
		int adder = -1;
		
		for(int i = 0; i < plaintext.length(); i++) {
			
			char c = plaintext.charAt(i);
			
			if(counter == 0 && i == 0) {
				
				counter = 0;
			}
			else if(counter == 0) {
				
				adder *= -1;
				counter += adder;
			}
			else if(counter < key - 1) {
				
				counter += adder;
			}
			else if(counter == key - 1) {
				
				adder *= -1;
				counter += adder;
			}
			
			String c_ = "";
			c_ += c;
			
			this.rails.get(counter).add(c_);
		}
	}
	
	/*
	 * Join the rails together, now we have the encrypted message.
	 * */
	private void joinRails() {
		
		String cipher = "";
		
		for(ArrayList<String> rail : rails) {
			
			for(String word : rail) {
				
				cipher += word;
			}
		}
		
		this.ciphertext = cipher;
	}
	
	/*
	 * Prints the final ciphertext to the console.
	 * */
	public void print() {
		
		System.out.println(plaintext + " -> " + ciphertext + "\n");
	}
}
