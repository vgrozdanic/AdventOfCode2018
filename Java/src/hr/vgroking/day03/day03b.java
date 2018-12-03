package hr.vgroking.day03;
/**
 * Ugly solution
 * @author vjeran
 *
 */
public class day03b {
	public static void main(String[] args) {
		int id = 0, leftEdge = 0, topEdge = 0, width, height;
		String current;
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
				
				for (int j=leftEdge; j<(leftEdge + width); j++) {
					for (int k=topEdge; k<(topEdge + height); k++) {
						map[j][k]++;
					}
					
				}
			}			
		}
		
		//second looping through arguments
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
				boolean onlyOnes = true;
				for (int j=leftEdge; j<(leftEdge + width); j++) {
					for (int k=topEdge; k<(topEdge + height); k++) {
						if (map[j][k] > 1) onlyOnes = false;
					}
				}
				if (onlyOnes) System.out.println(id);
			}			
		}
	}
}
