package hr.vgroking.day05;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class day05a {
	private static String input;
	private static int length;
	
	public static char XOR (char c) {
		return (char) ((int)c ^ 32);
	}
	
	public static int remainingUnits(String input, int length) {
		Stack<Character> stack = new Stack<>();
		
		for (int i=0; i<length; i++) {
			char c = input.charAt(i);
			char xorC = (char) ((int)c ^ 32); //xor with 32 to get opposite size of letter (a->A and A->a)
			
			if (i < length - 1) {
				char nextChar = input.charAt(i + 1);
				
				if (nextChar == xorC) { 
					i++;
					continue;
				}
			}
			char lastChar;

			try {
				lastChar = stack.pop();
			} catch (EmptyStackException e) {
				stack.push(c);
				continue;
			}

			if (lastChar != xorC) {
				stack.push(lastChar);
				stack.push(c);
			}
		}
		
		return stack.size();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.next();
		length = input.length();
		
		System.out.println("New length: " + remainingUnits(input, length));
	}

}
