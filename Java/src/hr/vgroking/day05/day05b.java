package hr.vgroking.day05;

import java.util.Scanner;

public class day05b {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int[] sizeOfReactions = new int[26];
		int length = input.length();
		
		for (int letter=0; letter<26; letter++) {
			String currentInput = input;
			currentInput = currentInput.replace(Character.toString((char)('A' + letter)), "");
			currentInput = currentInput.replace(Character.toString((char)('a' + letter)), "");

			for (int i=0; i<length; i++) {
				for (int j=0; j<length; j++) {
					String pattern1, pattern2;
					pattern1 = Character.toString((char)('A' + j)) + Character.toString((char)('a' + j)); 
					pattern2 = Character.toString((char)('a' + j)) + Character.toString((char)('A' + j));
					
					currentInput = currentInput.replace(pattern1, "");
					currentInput = currentInput.replace(pattern2, "");
				}
			}
			
			sizeOfReactions[letter] = currentInput.length();
		}
		
		int minimum = sizeOfReactions[0];
		for (int k=0; k<26; k++) {
			if (sizeOfReactions[k] < minimum)
				minimum = sizeOfReactions[k];
		}
		System.out.println("Minimum is: " + minimum);
	}

}
