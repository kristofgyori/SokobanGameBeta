package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import game.Box;

/**
 * a Box megjelenítéséért felelős osztály
 * 
 *
 */
public class GBox extends Drawable{
	/**
	 * a box melyet kirajzol
	 */
	private Box box;
	
	
	
	public void Draw(Graphics g) {
		if(box.getCurrentField()!=null)
		{
				BufferedImage img;
		if(box.getOnStorageArea()) //ha a box StorageArean áll
			img = View.images.get("placedBox");
		else
			img = View.images.get("box");	//ha nem
		
		g.drawImage(img, View.blockSize*box.getPos().getX(),  View.blockSize*box.getPos().getY(), null);		
		}
	}
	/**
	 * Box beállítása
	 * @param box
	 */
	public void setBox(Box box){
		this.box = box;
	}

}