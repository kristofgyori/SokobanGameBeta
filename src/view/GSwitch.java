package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import game.Switch;

public class GSwitch extends Drawable{
	
	private Switch sw;
	
	@Override
	public void Draw(JPanel panel) {
		Graphics2D g = (Graphics2D) panel.getGraphics();
		
		
		BufferedImage img;
		if(sw.getThing() == null)
			img = View.images.get("swOFF");
		else
			img = View.images.get("swON");
		
		g.drawImage(img, View.blockSize*sw.getPos().getX(),  View.blockSize*sw.getPos().getY(), null);		
	}
	
	@Override
	public void Draw(Graphics g) {
			
		BufferedImage img;
		if(sw.getThing() == null)
			img = View.images.get("swOFF");
		else
			img = View.images.get("swON");
		
		g.drawImage(img, View.blockSize*sw.getPos().getX(),  View.blockSize*sw.getPos().getY(), null);		
	}
	
	public void setSwitch(Switch sw) {
		this.sw = sw;
	}
}
