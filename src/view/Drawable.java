package view;
import java.awt.Graphics;

import javax.swing.JPanel;

/** 
 * Rajzolható osztályok interfésze.
 */
public abstract class Drawable implements Comparable<Drawable>{
	/**
	 * Mélység. Előbb az alsó (mélyebb) rétegek kerülnek kirajzolásra.
	 */
	private int z;
	
	/**
	 * Kirajzolja az adott objektumot.
	 * @param panel
	 */
	public abstract void Draw(JPanel panel);
	
	public abstract void Draw(Graphics g);
	
	/**
	 * Mélység beállítása.
	 * @param z mélység
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * Összehasonlítás mélység alapján. A nagyobb mélységűeket kell előbb kirajzolni.
	 */
	@Override
	public int compareTo(Drawable another) {		
		if(z < another.z)
			return 1;
		else if (z > another.z)
			return -1;
		else 
			return 0;
	}		
}