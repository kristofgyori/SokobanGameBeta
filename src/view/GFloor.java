package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import game.Floor;
import game.Friction;

public class GFloor extends Drawable{
	
	private Floor floor;
	
	@Override
	public void Draw(JPanel panel) {
		Graphics2D g = (Graphics2D) panel.getGraphics();
		
		BufferedImage img; 		
		
		if(floor.getFriction() == Friction.NORMAL)
			img = View.images.get("floor");
		else if(floor.getFriction() == Friction.OIL)
			img = View.images.get("oFloor");
		else
			img = View.images.get("hFloor");
	
		g.drawImage(img, View.blockSize*floor.getPos().getX(),  View.blockSize*floor.getPos().getY(), null);
	}
	
	
	@Override
	public void Draw(Graphics g) {				
		BufferedImage img; 		
		
		if(floor.getFriction() == Friction.NORMAL)
			img = View.images.get("floor");
		else if(floor.getFriction() == Friction.OIL)
			img = View.images.get("oFloor");
		else
			img = View.images.get("hFloor");
	
		g.drawImage(img, View.blockSize*floor.getPos().getX(),  View.blockSize*floor.getPos().getY(), null);
	}
	
	public void setFloor(Floor floor) {
		this.floor = floor;
	}

}
