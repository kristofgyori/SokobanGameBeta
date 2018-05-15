package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import game.Floor;
import game.Friction;
/**
 * a Floor megjelenítéséért felelős osztály
 * 
 *
 */
public class GFloor extends Drawable{
	/**
	 * a padló amit kirajzol
	 */
	private Floor floor;
	
	
	
	
	@Override
	public void Draw(Graphics g) {				
		BufferedImage img; 		
		
		if(floor.getFriction() == Friction.NORMAL)		//különböző kirajzolások a különböző súrlódásokhoz
			img = View.images.get("floor");
		else if(floor.getFriction() == Friction.OIL)
			img = View.images.get("oFloor");
		else
			img = View.images.get("hFloor");
	
		g.drawImage(img, View.blockSize*floor.getPos().getX(),  View.blockSize*floor.getPos().getY(), null);
	}
	/**
	 * a padló bállítása
	 * @param floor
	 */
	public void setFloor(Floor floor) {
		this.floor = floor;
	}

}
