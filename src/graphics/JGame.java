package graphics;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.glass.events.WindowEvent;

import controller.Controller;
import controller.EndGameController;

/**
 * Ez a játék ablaka
 *
 *
 */
public class JGame extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * A panel ami óben a játék kirajzolódik
	 */
	private GameBoard gameBoardPanel;
	private String fileName = new String();
	
	public JGame(JFrame starter, String filename) {
		this.fileName = filename;
		this.setTitle("Soko");
		this.setSize(655, 680);
		this.setLocation(425 + 50, 100 + 50); 				//Frame adatainak beállítása
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.gameBoardPanel = new GameBoard(this);
		this.add(gameBoardPanel);		
		this.addKeyListener(gameBoardPanel.getController());	//Billentyűkezelő hozzáadása
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    this.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent e) {
	            //System.out.println("Uncomment following to open another window!");
	            //MainPage m = new MainPage();
	            //m.setVisible(true);
	            starter.setEnabled(true);
	            e.getWindow().dispose();
	            System.out.println("JFrame Closed!");
	        }
	    });
	}
	
	
   
	public String getFileName() {
		return fileName;
	}
	
	
}
