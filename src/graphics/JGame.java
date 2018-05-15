package graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Controller;

public class JGame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private GameBoard gameBoardPanel = new GameBoard();
		
	public JGame() {
		this.setTitle("Soko");
		this.setSize(655, 680);
		this.setLocation(425 + 50, 100 + 50);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(gameBoardPanel);		
		this.addKeyListener(gameBoardPanel.getController());
	}
	
	
	public static void main(String args[]) {
	       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new JGame().setVisible(true);
            }
        });  
}
}
