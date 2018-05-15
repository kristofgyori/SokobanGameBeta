package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import game.Direction;
import game.Player;
/**
 * a Player megjelenítéséért felelős osztály
 * 
 *
 */
public class GPlayer extends Drawable{
	/**
	 * a játékos amit kirajzol
	 */
	Player player;

	
	
	
	@Override
	public void Draw(Graphics g) {
		if(player.getCurrentField()!=null)
		{
		
		BufferedImage img;
		
		Direction dir = player.getLastStep();
		
		String p;
		if(player.getID().equals("blue"))		//a szín meghatározása
			p = "p1";
		else				
			p = "p2";
		
		switch(dir) {							//az előző lépés alapján a kép kiválasztása
			case UP: 
				img = View.images.get(p+"Up");
				break;
			case  DOWN:
				img = View.images.get(p+"Down");
				break;
			case LEFT:
				img = View.images.get(p+"Left");
				break;
			default:
				img = View.images.get(p+"Right");
				break;
		}	
		
		g.drawImage(img, View.blockSize*player.getPos().getX(),  View.blockSize*player.getPos().getY(), null);
		}
	}

	/**
	 * a játékos beállítása
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

}
