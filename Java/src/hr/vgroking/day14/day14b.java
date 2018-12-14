package hr.vgroking.day14;

import java.util.ArrayList;
import java.util.Scanner;

public class day14b {
	private static final int numOfDigits = 6;  //number of digits in input
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		
		int first=0, second=1;
		
		ArrayList<Integer> scores = new ArrayList<>();
		scores.add(3);
		scores.add(7);
		
		boolean found = false;
		while (found == false) {
			int current = scores.get(first) + scores.get(second);
			if (current >= 10) {
				scores.add(current / 10);
				scores.add(current % 10);
			} else {
				scores.add(current);
			}
			first = (first + 1 + scores.get(first)) % scores.size();
			second = (second + 1 + scores.get(second)) % scores.size();
			
			if (scores.get(scores.size()-1) == Integer.parseInt(String.valueOf(input.charAt(numOfDigits-1))) 
					&& scores.size() > numOfDigits) {
				found = true;
				int size = scores.size() -1;
				for (int i=0; i<numOfDigits; i++) {
					Character c = input.charAt(numOfDigits - 1 - i);
					if (scores.get(size - i) != Integer.parseInt(c.toString())) {
						found = false;
						break;
					}
				}
				if (found)
					System.out.println(scores.size() - numOfDigits);
			} else if (current > 9 &&
					scores.get(scores.size()-2) == Integer.parseInt(String.valueOf(input.charAt(numOfDigits-1))) 
					&& scores.size() > numOfDigits + 1) {
				found = true;
				int size = scores.size() -2;
				for (int i=0; i<numOfDigits; i++) {
					Character c = input.charAt(numOfDigits - 1 - i);
					if (scores.get(size - i) != Integer.parseInt(c.toString())) {
						found = false;
						break;
					}
				}
				if (found)
					System.out.println(scores.size() - (numOfDigits + 1));
			}
		}
	}
}
