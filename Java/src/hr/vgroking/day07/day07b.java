package hr.vgroking.day07;

import java.util.HashSet;
import java.util.TreeSet;

public class day07b {

	public static void main(String[] args) {
		int[][] adjacency = new int[26][26];
		char first = 0, second = 0;
		HashSet<Character> nodes = new HashSet<>();

		for (int i=0; i<args.length; i++) {
			if (i%10 == 1) first = args[i].charAt(0);
			if (i%10 == 7) {
				second = args[i].charAt(0);
				nodes.add(first);
				nodes.add(second);
				first = (char) (first - 'A');
				second = (char) (second - 'A');
				adjacency[(int) first][(int) second] = 1;
			}
		}
		TreeSet<Character> availableChars = new TreeSet<>();
		HashSet<Character> usedNodes = new HashSet<>();
		for (int i=0; i<26; i++) {
			boolean emptyColumn = true;
			for (int j=0; j<26; j++) {
				if (adjacency[j][i] == 1) emptyColumn = false;
			}
			if (emptyColumn)
				if (nodes.contains((char) (i + 'A')))
					availableChars.add((char) (i + 'A'));
		}


		int[] workers = new int[5];
		char[] workingOn = new char[5];
		int seconds = 0;
		boolean workLeft = true;
		
		while (workLeft) {
			workLeft = false;
			for (int worker=0; worker<5; worker++) {
				if (workers[worker] > 0) {
					workers[worker]--;
					if (workers[worker] > 0)
						workLeft = true;
					
					if (workers[worker] == 0) {
						usedNodes.add(workingOn[worker]);
						for (int k=0; k<26; k++) {
							if (adjacency[(int) (workingOn[worker] - 'A')][k] == 1) {
								boolean isAllowedToExecute = true;
								for (int q=0; q<26; q++) {
									if (adjacency[q][k] == 1) {
										if (usedNodes.contains((char) (q + 'A')) == false)
											isAllowedToExecute = false;
									}
								}
								if (isAllowedToExecute)
									availableChars.add((char) (k + 'A'));
							}
						}
					}
				}
				if (availableChars.isEmpty() == false) {
					workLeft = true;
					char currentNode = availableChars.first();
					if (workers[worker] == 0) {
						workers[worker] = 60 + (int) (currentNode - 'A') + 1;
						workingOn[worker] = currentNode;
						availableChars.remove(currentNode);
					}
				}
			}
			
			if (workLeft)
				seconds++;
		}
		
		
		
		
		
		System.out.println(seconds);
	}
}