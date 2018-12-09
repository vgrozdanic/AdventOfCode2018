package hr.vgroking.day08;

import java.util.ArrayList;

public class day08a {
	private static ArrayList<Integer> data = new ArrayList<>();
	private static int position = 0;
	
	private static int sumMetadata (int numOfNodes, int numOfMeta) {
		int sum = 0;		
		
		for (int i=0; i<numOfNodes; i++) {
			sum += sumMetadata(data.get(position++), data.get(position++));
		}
		
		for (int j=0; j<numOfMeta; j++) {
			sum += data.get(position++);
		}
		
		return sum;
	}

	public static void main(String[] args) {
		for (int i=0; i<args.length; i++) {
			data.add(Integer.parseInt(args[i]));
		}		
		
		System.out.println("Result is: " + sumMetadata(data.get(position++), data.get(position++)));
	}

}
