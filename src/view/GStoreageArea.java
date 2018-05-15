package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import game.StoreageArea;
/**
 * a StorageArea megjelenítéséért felelős osztály
 * 
 *
 */
public class GStoreageArea extends Drawable{
	/**
	 * a StorageArea amit kirajzol
	 */
	private StoreageArea area;
	
	
	
	@Override
	public void Draw(Graphics g) {
				
		BufferedImage img = View.images.get("sArea");
		
		g.drawImage(img, View.blockSize*area.getPos().getX(),  View.blockSize*area.getPos().getY(), null);		
	}
	/**
	 * a StorageArea beállítása
	 * @param area
	 */
	public void setStorageArea(StoreageArea area) {
		this.area = area;
	}
}
