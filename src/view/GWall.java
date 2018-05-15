package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import game.Wall;
/**
 * a Wall megjelenítéséért felelős osztály
 * 
 *
 */
public class GWall extends Drawable{
	/**
	 * a wall amit kirajzol
	 */
	private Wall wall;
	

	@Override
	public void Draw(Graphics g) {
		
		BufferedImage img = View.images.get("wall");
		g.drawImage(img, View.blockSize*wall.getPos().getX(),  View.blockSize*wall.getPos().getY(), null);		
	}
	/**
	 * a wall beállítása
	 * @param wall
	 */
	public void setFloor(Wall wall){
		this.wall = wall;
	}

}