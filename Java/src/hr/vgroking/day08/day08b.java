package hr.vgroking.day08;

import java.util.ArrayList;

public class day08b {
	private static ArrayList<Integer> data = new ArrayList<>();
	private static int position = 0;
	
	private static int sumMetadata (int numOfNodes, int numOfMeta) {
		int sum = 0;
		ArrayList<Integer> valueOfChildren = new ArrayList<>();
		
		for (int i=0; i<numOfNodes; i++) {
			valueOfChildren.add(sumMetadata(data.get(position++), data.get(position++)));
		}
		
		if (numOfNodes == 0) {
			for (int j=0; j<numOfMeta; j++) {
				sum += data.get(position++);
			}
		}else {
			for (int k=0; k<numOfMeta; k++) {
				int currenteMeta = data.get(position++);
				if (currenteMeta -1 < valueOfChildren.size()) 
					sum += valueOfChildren.get(currenteMeta-1);
			}
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
