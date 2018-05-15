package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import game.Wall;

public class GWall extends Drawable{
	
	private Wall wall;
	

	@Override
	public void Draw(Graphics g) {
		
		BufferedImage img = View.images.get("wall");
		g.drawImage(img, View.blockSize*wall.getPos().getX(),  View.blockSize*wall.getPos().getY(), null);		
	}
	
	public void setFloor(Wall wall){
		this.wall = wall;
	}

}