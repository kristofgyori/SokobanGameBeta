package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import game.Direction;
import game.Player;

public class GPlayer extends Drawable{
	
	Player player;

	
	@Override
	public void Draw(JPanel panel) {
		if(player.getCurrentField()!=null)
		{
		Graphics2D g = (Graphics2D) panel.getGraphics();
		BufferedImage img;
		
		Direction dir = player.getLastStep();
		
		String p;
		if(player.getID().equals("blue"))
			p = "p1";
		else
			p = "p2";
		
		switch(dir) {
			case UP: 
				img = View.images.get(p+"Up");
				break;
			case  DOWN:
				img = View.images.get(p+"Down");
				break;
			case LEFT:
				img = View.images.get(p+"Left");
				break;
			default:
				img = View.images.get(p+"Right");
				break;
		}	
		
		g.drawImage(img, View.blockSize*player.getPos().getX(),  View.blockSize*player.getPos().getY(), null);
		}
	}
	
	@Override
	public void Draw(Graphics g) {
		if(player.getCurrentField()!=null)
		{
		
		BufferedImage img;
		
		Direction dir = player.getLastStep();
		
		String p;
		if(player.getID().equals("blue"))
			p = "p1";
		else
			p = "p2";
		
		switch(dir) {
			case UP: 
				img = View.images.get(p+"Up");
				break;
			case  DOWN:
				img = View.images.get(p+"Down");
				break;
			case LEFT:
				img = View.images.get(p+"Left");
				break;
			default:
				img = View.images.get(p+"Right");
				break;
		}	
		
		g.drawImage(img, View.blockSize*player.getPos().getX(),  View.blockSize*player.getPos().getY(), null);
		}
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
