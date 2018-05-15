package graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private GameBoard gameBoardPanel = new GameBoard(this);
		
	public JGame() {
		this.setTitle("Soko");
		this.setSize(655, 680);
		this.setLocation(425 + 50, 100 + 50); 				//Frame adatainak beállítása
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(gameBoardPanel);		
		this.addKeyListener(gameBoardPanel.getController());	//Billentyűkezelő hozzáadása
	}
	
	/**
	 * A program belépési pontja
	 * @param args
	 */
	public static void main(String args[]) {
	       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new JGame().setVisible(true);
            }
        });  
}
}
