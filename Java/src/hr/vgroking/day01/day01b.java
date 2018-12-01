package hr.vgroking.day01;

import java.util.HashSet;

public class day01b {

	public static void main(String[] args) {
		HashSet<Integer> hashOfSum = new HashSet<>();
		int sum = 0, n;
		boolean isFound = false; 
		
		while(true) {
			if (isFound) break;
			
			for (int i=0; i<args.length; i++) {
				n = Integer.parseInt(args[i]);
				sum += n;
				
				if (hashOfSum.contains(sum)) {
					System.out.println(sum);
					isFound = true;
					break;
				}else {
					hashOfSum.add(sum);
				}
			}
		}
		
	}

}
