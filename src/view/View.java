package view;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import graphics.GameBoard;
import observerPattern.Observable;
import observerPattern.Observer;
/**
 * a megfigyelő ami a különböző objektumok kirajzolását hajtja végre
 * 
 *
 */
public class View implements Observer{
	/**
	 * A panel mely vászonként szolgál
	 */
	private JPanel canvas;
	
	/**
	 * A rajzolható objektumokat tartalmazza.
	 */
	private List<Drawable> drawables;	
	
	/**
	 * Előre betöltött képek.
	 */
	public static Map<String, BufferedImage> images = new HashMap<>();
	public static final int blockSize = 64; //64px * 64px mezőméret
	
	/**
	 * Privát kép betöltő rutin.
	 */
	private BufferedImage loadImg(String path) throws IOException {
		return ImageIO.read(new File(path));			
	}
	
	/**
	 * A konstruktorban töltődnek be a képek.
	 */
	public View() {
		
		try {			
			images.put("box", loadImg("bin\\pictures\\Box.png"));
			images.put("floor", loadImg("bin\\pictures\\floor.png"));			
			images.put("hole", loadImg("bin\\pictures\\hole.png"));
			images.put("hFloor", loadImg("bin\\pictures\\HoneyFloor.png"));
			images.put("oFloor", loadImg("bin\\pictures\\OilFloor.png"));
			images.put("placedBox", loadImg("bin\\pictures\\PlacedBox.png"));			
			
			images.put("p1Up", loadImg("bin\\pictures\\Player1_UP.png"));			
			images.put("p1Down", loadImg("bin\\pictures\\Player1_DOWN.png"));
			images.put("p1Left", loadImg("bin\\pictures\\Player1_LEFT.png"));			
			images.put("p1Right", loadImg("bin\\pictures\\Player1_RIGHT.png"));
			
			images.put("p2Up", loadImg("bin\\pictures\\Player2_UP.png"));			
			images.put("p2Down", loadImg("bin\\pictures\\Player2_DOWN.png"));
			images.put("p2Left", loadImg("bin\\pictures\\Player2_LEFT.png"));			
			images.put("p2Right", loadImg("bin\\pictures\\Player2_RIGHT.png"));
			
			
			images.put("sArea", loadImg("bin\\pictures\\StoreAgeArea.png"));
			images.put("swON", loadImg("bin\\pictures\\SwitchOn.png"));
			images.put("swOFF", loadImg("bin\\pictures\\SwitchOff.png"));
			images.put("trap", loadImg("bin\\pictures\\trapdoor.png"));
			
			images.put("wall", loadImg("bin\\pictures\\wall.png"));		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Rajzolható objektum lista átadása.
	 * @param list
	 */
	public void set(List<Drawable> list) {
		drawables = list;
		Collections.sort(drawables); // rendezzés rajzolási sorrend szerint
	}
	
	/**
	 * A JPanel átadása. Ide fog rajzolni.
	 * @param panel
	 */
	public void set(JPanel img) {
		canvas = img;
	}
		
	/**
	 *  Kirajzolja az összes drawable-t.
	 */
	public void update() {
		
		GraphicsUpdate(canvas.getGraphics());
	}
	
	public void GraphicsUpdate(Graphics g) {
		for (Drawable drawable : drawables) {
			//drawable.Draw(canvas);
			drawable.Draw(g);
		}
	}
		
	
	/**
	 * A megfigyelt objektumoktól kapott értesítés.
	 */
	@Override
	public void report(Observable o) {
		update();		
	}
	
}
