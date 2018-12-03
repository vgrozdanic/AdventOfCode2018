package hr.vgroking.day03;

import java.util.ArrayList;

public class day03a {

	public static void main(String[] args) {
		int id, leftEdge = 0, topEdge = 0, width, height;
		String current;
//		ArrayList<Integer> first = new ArrayList<>(), 
//				second = new ArrayList<>();
		int[][] map = new int[1500][1500];
		
		for (int i=0; i<args.length; i++) {
			current = args[i];
			
			if (i%4 == 0)
				id = Integer.parseInt(current.split("#")[1]);
			
			if (i%4 == 1); //does nothing, this argument in args is equal to "@"
			
			if (i%4 == 2) {
				String[] parts = current.split(",");
				leftEdge = Integer.parseInt(parts[0]);
				topEdge = Integer.parseInt(parts[1].split(":")[0]);
			}
			
			
			if (i%4 == 3) {
				String[] parts = current.split("x");
				width = Integer.parseInt(parts[0]);
				height = Integer.parseInt(parts[1]);
//				first.add(leftEdge);
//				second.add(topEdge);
//				first.add(leftEdge + width);
//				second.add(topEdge + height);
				
				for (int j=leftEdge; j<(leftEdge + width); j++) {
					for (int k=topEdge; k<(topEdge + height); k++) {
						map[j][k]++;
					}
					
				}
			}			
		}
		
		int count = 0;
		
		for (int i=0; i<1500; i++) {
			for (int j=0; j<1500; j++) {
				if (map[i][j] > 1) count++;
			}
		}
		
		System.out.println(count);
	}

}
