package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
/**
 * Ez az ablak akkor jön létre amikor a játéknak vége, a végeredményt láthatjuk rajta
 * @author Felhasználó
 *
 */
public class JGameOver extends JFrame {
	
	private static final long serialVersionUID = 1L;	
	
	public JGameOver(long p1Points, long p2Points)
	{
		this.setSize(320, 300);
		this.setLocation(425, 100);						//ablak adatainak beállítása
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		JPanel mainPanel=new JPanel(new BorderLayout());	//ablakban lévő panel amelyre az információk kerülnek
		mainPanel.setSize(320,300);							
		mainPanel.setLocation(0, 0);						//panel adatainak beállítása
		mainPanel.setLayout(null);
		this.getContentPane().add(mainPanel);
		
		JLabel player1Label=new JLabel("Player 1:  "+p1Points+"  points");		//játékosok pontjainak "kiírása"
		JLabel player2Label=new JLabel("Player 2:  "+p2Points+"  points");
		JLabel winLabel;
		if(p1Points>p2Points)													//végeredmény
			winLabel=new JLabel("Player 1 wins!");
		else if(p2Points>p1Points)
			winLabel=new JLabel("Player 2 wins!");
		else
			winLabel=new JLabel("Scores");
		
		
		winLabel.setSize(300, 20);
		winLabel.setLocation(new Point(90,50));
		
		player1Label.setSize(300, 20);
		player1Label.setLocation(new Point(90,100));			//Labelek mérete és pozíciója
		
		player2Label.setSize(300, 20);
		player2Label.setLocation(new Point(90,150));
		
		mainPanel.add(player1Label);
		mainPanel.add(player2Label);							//elemek hozzáadása a Framehez
		mainPanel.add(winLabel);
		
		
		
		
	}
	
}
