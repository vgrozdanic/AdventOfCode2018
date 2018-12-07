package hr.vgroking.day07;

import java.util.HashSet;
import java.util.TreeSet;

public class day07a {
	
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
		
		StringBuilder output = new StringBuilder();
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
		
		
		while (availableChars.isEmpty() == false) {
			char currentNode = availableChars.first();
			output.append(currentNode);
			availableChars.remove(currentNode);
			usedNodes.add(currentNode);
			for (int k=0; k<26; k++) {
				if (adjacency[(int) (currentNode - 'A')][k] == 1) {
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
		
		System.out.println(output);
		
		
	}
}
