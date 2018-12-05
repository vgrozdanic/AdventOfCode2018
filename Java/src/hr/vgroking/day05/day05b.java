package hr.vgroking.day05;

import java.util.Scanner;

public class day05b {
	private static String input;
	private static int length;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.next();
		length = input.length();
		
		int min = 0;
		for (int i=0; i<26; i++) {
			char currentChar = (char) ('A' + i);
			String pattern = currentChar + "|" + day05a.XOR(currentChar);
			String current = input.replaceAll(pattern, "");
			
			if (i == 0) min = day05a.remainingUnits(current, current.length());
			
			if (i != 0) {
				int units = day05a.remainingUnits(current, current.length());
				if (units < min) min = units;
			}
		}
		
		System.out.println("Smallest result: " + min);
		
	}

}
