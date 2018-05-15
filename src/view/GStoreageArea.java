package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import game.StoreageArea;

public class GStoreageArea extends Drawable{
	
	private StoreageArea area;
	
	@Override
	public void Draw(JPanel panel) {
		Graphics2D g = (Graphics2D) panel.getGraphics();
		
		BufferedImage img = View.images.get("sArea");
		
		g.drawImage(img, View.blockSize*area.getPos().getX(),  View.blockSize*area.getPos().getY(), null);		
	}
	
	@Override
	public void Draw(Graphics g) {
				
		BufferedImage img = View.images.get("sArea");
		
		g.drawImage(img, View.blockSize*area.getPos().getX(),  View.blockSize*area.getPos().getY(), null);		
	}
	
	public void setStorageArea(StoreageArea area) {
		this.area = area;
	}
}
