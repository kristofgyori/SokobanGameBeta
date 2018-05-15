package game;

import java.util.LinkedList;
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

import javafx.beans.InvalidationListener;
import observerPattern.Observable;
import observerPattern.Observer;


/**
 * 
 * A játékot irányító osztály ebben inicializálódik a minden a játékhoz szükséges adat
 *
 */
public class Game implements Observable{
	/**
	 * az adott pálya mezői
	 */	
	private List<Field> maze;

	
	/**
	 * Az értesítendő objektumokat tárolja
	 */
	List<Observer> observers = new LinkedList<>();
	
	
	/**
	 * a pályán lévő játékosok listája
	 */
	private List<Player> players;
	/**
	 * pályán lévő StorageArea-k listája
	 */
	private List<StoreageArea> sAreas;
	
	/**
	 * Véget vet a játéknak
	 * a játék befejezésekor végrehajtandó műveleteket végzi el
	 */
	public void endGame() {	
		reportToObservers();
	}
	/**
	 * visszaadja a játékosok listáját
	 * @return játékosok listája
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * beállítja a játékosok listáját
	 * @param players játékosok listája
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * beállítja a game Fieldjeinek listáját
	 * @param maze
	 */
	public void setMaze(List<Field> maze) {
		this.maze = maze;
	}
	/**
	 * beállítja a célhelyek listáját
	 * @param sAreas
	 */
	public void setsAreas(List<StoreageArea> sAreas)
	{
		this.sAreas=sAreas;
	}
	/**
	 * megvizsgálja, hogy be kell-e fejezni a játékot
	 * @return
	 */
	public boolean isEnd()
	{
		boolean end=true;
		for(int i=0;i<sAreas.size();i++)
		{
			if(sAreas.get(i).isOccupied()==false)
				end=false;
		}
		return end;
	}

	/**
	 * eseményt küld az observereknek
	 */
	@Override
	public void reportToObservers() {
		for (Observer obs : observers) {
			obs.report(this);
		}
		
	}

	/**
	 * új observer hozzáadása
	 */
	@Override
	public void register(Observer obs) {
		if(! observers.contains(obs))		//csak ha még nincs benne
			observers.add(obs);
		
	}

	/**
	 * observer eltávolítása
	 */
	@Override
	public void unregister(Observer obs) {
		observers.remove(obs);			
	}
}
