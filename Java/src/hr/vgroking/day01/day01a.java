package hr.vgroking.day01;

/**
 * Input is given as command line arguments
 * @author vjeran
 *
 */
public class day01a {

	public static void main(String[] args) {
		int sum = 0, n;
		
		for (int i=0; i<args.length; i++) {
			n = Integer.parseInt(args[i]);
			sum += n;
		}
		
		System.out.println(sum);
	}

}
