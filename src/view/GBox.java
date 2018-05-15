package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import game.Box;


public class GBox extends Drawable{
	
	private Box box;
	
	
	
	public void Draw(Graphics g) {
		if(box.getCurrentField()!=null)
		{
				BufferedImage img;
		if(box.getOnStorageArea())
			img = View.images.get("placedBox");
		else
			img = View.images.get("box");
		
		g.drawImage(img, View.blockSize*box.getPos().getX(),  View.blockSize*box.getPos().getY(), null);		
		}
	}
	
	public void setBox(Box box){
		this.box = box;
	}

}