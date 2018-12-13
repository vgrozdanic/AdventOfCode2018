package hr.vgroking.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Using complex numbers as coordinates
 * @param args
 */
public class day13a {
	private static char[][] map = new char[150][150];	
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input-file");
		Scanner sc = new Scanner(file);
		ArrayList<Cart> carts = new ArrayList<>();
		
		int row = 0;
		while(sc.hasNext()) {
//			System.out.println(row);
			String line = sc.nextLine();
			for (int column=0; column<150; column++) {
				char current = line.charAt(column);
				if (current == '^' || current == 'v' || current == '<' || current == '>') {
					Cart cart = null;
					if (current == '^' || current == 'v') {
						cart = (new Cart(current, column, row, '|'));
					}
					else if (current == '<' ||current == '>') {
						cart = (new Cart(current, column, row, '-'));
					}
					carts.add(cart);
				}
				map[row][column] = current;
			}
			row++;
		}
		
		boolean crash = false;
		while (crash == false) {
			HashSet<Cart> movedCarts = new HashSet<>();
			for (int x=0; x<150; x++) {
				for (int y=0; y<150; y++) {
					char current = map[y][x];
		
					if (current == '^' || current == 'v' || current == '<' || current == '>') {
						Cart cart = null;
						for (int q=0; q<carts.size(); q++) {
							Cart it = carts.get(q);
							if (it.x == x && it.y == y) {
								cart = it;
							}
						}
						
						if (movedCarts.contains(cart) == false) {
							movedCarts.add(cart);
							cart.moveNext(map);
							map[y][x] = cart.current;
							char n = map[cart.y][cart.x];


							if (n == '^' || n == 'v' || n == '<' || n == '>') {
								crash = true;
								System.out.println("Crash happend on: " + cart.x + ", " + cart.y);
								break;
							} else {
								cart.current = map[cart.y][cart.x];
								map[cart.y][cart.x] = cart.direction;
								x = cart.x;
								y = cart.y;
							}

						}
					}
					
				}
			}
		}
		
		
	}

}
