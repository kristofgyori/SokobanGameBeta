package graphics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.Controller;
/**
 * ebben a panelben rajzolódik ki a játék
 *
 *
 */
public class GameBoard  extends JPanel {
	
	private static final long serialVersionUID = 1L;
	/**
	 * A Frame referenciája amiben benne van
	 */
	private JFrame frame;
	/**
	 * A controller ami majd az billentyűlenyomásokat kezeli
	 * és létrehozza a játékot
	 */
	Controller cnt = new Controller("bin\\maps\\test.txt", this);
	/**
	 * konstruktor
	 * @param frame
	 */
	public GameBoard(JFrame frame)
	{
		this.frame=frame;
	}
	/**
	 * Visszaadja a Framet
	 * @return
	 */
	public JFrame getFrame()
	{
		return frame;
	}
	/**
	 * Visszaadja a Controllert
	 * @return
	 */
	public Controller getController() {
		return cnt;
	}
	/**
	 * kirajzolás
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		cnt.getView().set(this);
		cnt.getView().GraphicsUpdate(g);
	}
}
