
/**
* @Project : KillerSokoban
* @fileName Direction.java
* @date : 3/13/2018
* @author : 
*/

package game;
/**
 * 
 * Enumeráció az irányoknak
 *
 */
public enum Direction {		
	UP, DOWN, LEFT, RIGHT;
	
	public Direction getInverse(Direction d) {
		if (d == UP)    return DOWN;
		else if (d == DOWN)  return UP;
		else if (d == LEFT)  return RIGHT;
		else return LEFT;
	}
}
