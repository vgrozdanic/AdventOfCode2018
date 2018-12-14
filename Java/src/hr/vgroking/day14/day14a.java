package hr.vgroking.day14;

import java.util.ArrayList;
import java.util.Scanner;

public class day14a {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		int first=0, second=1;
		
		ArrayList<Integer> scores = new ArrayList<>();
		scores.add(3);
		scores.add(7);
		
		while (scores.size() < input+11) {
			int current = scores.get(first) + scores.get(second);
			if (current >= 10) {
				scores.add(current / 10);
				scores.add(current % 10);
			} else {
				scores.add(current);
			}
			first = (first + 1 + scores.get(first)) % scores.size();
			second = (second + 1 + scores.get(second)) % scores.size();
		}
		
		for (int i=input; i<(input + 10); i++) {
			System.out.print(scores.get(i));
		}
	}

}
