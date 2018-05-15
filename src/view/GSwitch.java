package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import game.Switch;
/**
 * a Switch megjelenítéséért felelős osztály
 * 
 *
 */
public class GSwitch extends Drawable{
	/**
	 * a Switch amit kirajzol
	 */
	private Switch sw;
	

	
	@Override
	public void Draw(Graphics g) {
			
		BufferedImage img;
		if(sw.getThing() == null)
			img = View.images.get("swOFF");
		else
			img = View.images.get("swON");
		
		g.drawImage(img, View.blockSize*sw.getPos().getX(),  View.blockSize*sw.getPos().getY(), null);		
	}
	/**
	 * a Switch beállítása
	 */
	public void setSwitch(Switch sw) {
		this.sw = sw;
	}
}
