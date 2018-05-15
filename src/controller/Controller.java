package controller;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;

import game.*;
import proto.MapLoader;
import view.View;

public class Controller implements KeyListener{

	/**
	 * A betöltendő pálya elérési útja.
	 */
	String filePath;
	
	/**
	 * A játék modell része
	 */
	Game g = new Game();
	
	/**
	 * A játék grafikus (view) része
	 */
	View v = new View();
	
	/**
	 * A játék objektumainak fájból való betöltéséhez.
	 */
	MapLoader ml = new MapLoader();
	
	/**
	 * A játékosok.
	 */
	List<Player> players;
	
	
	public Controller(String mapPath, JPanel panel) {
		filePath = mapPath;
				
		InputStream is = null;
		try {
			is = new FileInputStream(new File(filePath)); //fájl megnyitása
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ml.Load(is);								//pálya betöltése és a szükséges változók beállítása
		players = ml.getPlayers();
		g.setMaze(ml.getFields());
		v.set(ml.getDrawables()); 				
		v.set(panel);
				
		for (Player p : players) {					//játékosoknak a pálya átadása
			p.setGame(g);
			p.register(v);	
		}
		
		players.get(0).setID("green");
		players.get(1).setID("blue");		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		boolean deadPlayer=false;
		for (int i=0;i<players.size();i++)
		{
			if(players.get(i).getCurrentField()==null)
				deadPlayer=true;
		}
		
		int keyCode = e.getKeyCode();		
		switch(keyCode) {
		
		//PLAYER0 wasd / 123
			case KeyEvent.VK_UP:
				players.get(0).step(Direction.UP);
				break;
			
			case KeyEvent.VK_DOWN:
				players.get(0).step(Direction.DOWN);
				break;
			
			case KeyEvent.VK_LEFT:
				players.get(0).step(Direction.LEFT);
				break;
				
			case KeyEvent.VK_RIGHT:
				players.get(0).step(Direction.RIGHT);
				break;
				
			case KeyEvent.VK_NUMPAD1:
				players.get(0).setFriction(Friction.OIL);
				break;
				
			case KeyEvent.VK_NUMPAD2:
				players.get(0).setFriction(Friction.NORMAL);
				break;
				
			case KeyEvent.VK_NUMPAD3:
				players.get(0).setFriction(Friction.HONEY);
				break;
			
			//PLAYER1: nyilak/numpad123
			case KeyEvent.VK_W:
				players.get(1).step(Direction.UP);
				break;
				
			case KeyEvent.VK_S:
				players.get(1).step(Direction.DOWN);
				break;
				
			case KeyEvent.VK_A:
				players.get(1).step(Direction.LEFT);
				break;
				
			case KeyEvent.VK_D:
				players.get(1).step(Direction.RIGHT);
				break;
				
			case KeyEvent.VK_0:
				players.get(1).setFriction(Friction.OIL);
				break;
				
			case KeyEvent.VK_1:
				players.get(1).setFriction(Friction.NORMAL);
				break;
				
			case KeyEvent.VK_2:
				players.get(1).setFriction(Friction.HONEY);
				break;
						
			default:
				// Érvénytelen bill.
				break;
		}		
	}


	@Override
	public void keyReleased(KeyEvent e) {		
		
	}


	@Override
	public void keyTyped(KeyEvent e) {		
		
	}
	
	public View getView() {
		return v;
	}

	
	
}
