package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import game.TrapDoor;
/**
 * a TrapDoor megjelenítéséért felelős osztály
 * 
 *
 */
public class GTrapDoor extends Drawable{
	/**
	 * a TrapDoor amit kirajzol
	 */
	private TrapDoor trap;
	
	
	
	@Override
	public void Draw(Graphics g) {
			
		BufferedImage img;
		if(trap.getState())
			img = View.images.get("hole"); //ha nyitva van akkor holenak néz ki
		else
			img = View.images.get("trap"); //egyébként
		
		g.drawImage(img, View.blockSize*trap.getPos().getX(),  View.blockSize*trap.getPos().getY(), null);		
	}
	/**
	 * a TrapDoor beállítása
	 * @param trap
	 */
	public void setTrapDoor(TrapDoor trap) {
		this.trap = trap;
	}

}