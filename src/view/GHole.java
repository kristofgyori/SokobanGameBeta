package view;

import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import game.Hole;
/**
 * a Hole megjelenítéséért felelős osztály
 * 
 *
 */
public class GHole extends Drawable{
	/**
	 * a lyuk amit kirajzol
	 */
	private Hole hole;
	
	
	
	@Override
	public void Draw(Graphics g) {
		
		BufferedImage img = View.images.get("hole");
		g.drawImage(img, View.blockSize*hole.getPos().getX(),  View.blockSize*hole.getPos().getY(), null);
		
	}
	/**
	 * a lyuk beállítása
	 * @param hole
	 */
	public void setHole(Hole hole) {
		this.hole = hole;
	}

}