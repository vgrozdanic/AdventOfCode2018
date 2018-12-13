package hr.vgroking.day13;

public class Cart {
	public char direction;
	public char current;
	public int x, y;
	private final char[] intersectionDirection = {'L', 'S', 'R'};
	private int intersectionCurrent = 0;
	
	public Cart(char direction, int x, int y, char current) {
		this.direction = direction;
		this.x = x;
		this.y = y;
		this.current = current;
	}
	
	public void nextIntersection() {
		char next = intersectionDirection[intersectionCurrent%3];
		intersectionCurrent++;
		switch (next) {
		case 'L':
			if (direction == '^') { 
				direction = '<';
				x--;
			}
			else if (direction == 'v') {
				direction = '>';
				x++;
			}
			else if (direction == '<') {
				direction = 'v';
				y++;
			}
			else {
				direction = '^';
				y--;
			}
			break;
		case 'R':
			if (direction == '^') { 
				direction = '>';
				x++;
			}
			else if (direction == 'v') {
				direction = '<';
				x--;
			}
			else if (direction == '<') {
				direction = '^';
				y--;
			}
			else {
				direction = 'v';
				y++;
			}
			break;
			default:
				switch (direction) {
				case '^':
					y--;
					break;
				case 'v':
					y++;
					break;
				case '<':
					x--;
					break;
				default:
					x++;
					break;
				}
				break;
		}
	}
	
	public void moveNext(char[][] map) {
		switch (direction) {
		case '^':
			switch (current) {
			case '|':
				this.y--;
				break;
			case '/':
				this.x++;
				direction = '>';
				break;
			case '\\':
				this.x--;
				direction = '<';
				break;
			case '+':
				nextIntersection();
				break;
			}			
			break;
		
		case 'v':
			switch (current) {
			case '|':
				this.y++;
				break;
			case '/':
				this.x--;
				direction = '<';
				break;
			case '\\':
				this.x++;
				direction = '>';
				break;
			case '+':
				nextIntersection();
				break;
			}			
			break;
			
		case '<':
			switch (current) {
			case '-':
				this.x--;
				break;
			case '/':
				this.y++;
				direction = 'v';
				break;
			case '\\':
				this.y--;
				direction = '^';
				break;
			case '+':
				nextIntersection();
				break;
			}			
			break;
			
		case '>':
			switch (current) {
			case '-':
				this.x++;
				break;
			case '/':
				this.y--;
				direction = '^';
				break;
			case '\\':
				this.y++;
				direction = 'v';
				break;
			case '+':
				nextIntersection();
				break;
			}			
			break;

		default:
			break;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
