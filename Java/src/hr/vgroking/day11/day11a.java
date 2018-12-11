package hr.vgroking.day11;

import java.util.Scanner;

public class day11a {
	private static int[][] sum = new int[301][301];
	
	private static int partialSum(int x, int y) {
		int partialSum = 0;
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				partialSum += sum[x-i][y-j];
			}
		}
			
		return partialSum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int serial = sc.nextInt();
		int x0 = 1, y0 = 1, maxSum = 0;
		
		for (int x=1; x<301; x++) {
			int id = x + 10;
			for (int y=1; y<301; y++) {
				int powerLevel = (((id * y) + serial) * id) / 100 % 10 - 5;
				sum[x][y] = powerLevel;
				
				if (x>2 && y>2) {
					int partialSum = partialSum(x,y);
					if (partialSum > maxSum) {
						maxSum = partialSum;
						x0 = x-2;
						y0 = y-2;
					}
				}
			}
		}
		
		System.out.println("Coordinates are: " + x0 + ", " + y0);
	}

}
