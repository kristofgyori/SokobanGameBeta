package controller;

import observerPattern.Observer;

import javax.swing.JFrame;

import game.Game;
import graphics.JGameOver;
import observerPattern.Observable;

/**
 * 
 * a játék leállításáért felelős osztály, ennek szól a Game, hogy vége a játéknak
 *
 */
public class EndGameController implements Observer{

	/**
	 * az ablak amiben a játék fut
	 */
	private JFrame currentFrame;
	/**
	 * a játék referenciája
	 */
	private Game currentGame;
	
	public EndGameController(JFrame frame,Game game)
	{
		currentFrame=frame;
		currentGame=game;
	}
	/**
	 * ha vége a játéknak létrehoz egy másik ablakkot amiben az eredmény látható
	 */
	@Override
	public void report(Observable o) {
		long player1Points=currentGame.getPlayers().get(0).getPoints();
		long player2Points=currentGame.getPlayers().get(1).getPoints();
		new JGameOver(player1Points,player2Points);
		
	}

}
