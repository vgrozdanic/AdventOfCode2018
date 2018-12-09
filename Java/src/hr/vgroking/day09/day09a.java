package hr.vgroking.day09;

import java.util.ArrayList;
import java.util.Scanner;

public class day09a {
	
	public static void main (String[] args) {
		int numberOfPlayers, lastMarble;
		Scanner sc = new Scanner(System.in);
		numberOfPlayers = sc.nextInt();
		lastMarble = sc.nextInt();
		
		ArrayList<Integer> marbles = new ArrayList<>();
		int[] score = new int[numberOfPlayers];
		int currentIndex = 1;
		marbles.add(0);
		marbles.add(1);
		for (int i=2; i<=lastMarble; i++) {
			int size = marbles.size();
			if (i%23 == 0) {
				score[(i-1) % numberOfPlayers] += i;
				currentIndex -= 7;
				if (currentIndex < 0) currentIndex = size + currentIndex;
				score[(i-1) % numberOfPlayers] += marbles.get(currentIndex);
				marbles.remove(currentIndex);
				continue;
			}
			
			if (currentIndex+2 == size)
				currentIndex = size;
			else
				currentIndex = (currentIndex + 2) % size;
			
			marbles.add(currentIndex, i);			
		}
		
		int max = 0;
		for (int i=0; i<numberOfPlayers; i++) {
			if (score[i] > max) {
				max = score[i];
			}
		}
		
		System.out.println("Max is: " + max);
		
	}
}
