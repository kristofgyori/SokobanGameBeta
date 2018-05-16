package game;

/*import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import proto.Interpreter;
import proto.MapLoader;
import graphics.JMainMenu; 
import proto.Matrix;*/
import java.util.List;

/**
 * 
 * A játékot irányító osztály ebben inicializálódik a minden a játékhoz szükséges adat
 *
 */
public class Game {
	/**
	 * az adott pálya mezői
	 */	
	private List<Field> maze; //TODO csere generikus kollekcóra
	//private Field[][] map; 
	
	/**
	 * a pályán lévő játékosok listája
	 */
	private List<Player> players;	
	
	/**
	 * elindítja a játékot
	 */
	public void startGame() {
		//TODO
		//this.gameMainLoop();
	}

	/**
	 * Játékos halálakor hívódik.
	 * a játék befejezésekor végrehajtandó műveleteket végzi el
	 */
	public void endGame() {	
		//TODO
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void setMaze(List<Field> maze) {
		this.maze = maze;
	}
	
	
}
