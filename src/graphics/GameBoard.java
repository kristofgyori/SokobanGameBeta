package graphics;
import java.awt.Graphics;
import javax.swing.JPanel;
import controller.Controller;

public class GameBoard  extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Controller cnt = new Controller("bin\\maps\\test.txt", this);
	
	public Controller getController() {
		return cnt;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		cnt.getView().set(this);
		cnt.getView().GraphicsUpdate(g);
	}
}
