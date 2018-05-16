/**
* @Project : KillerSokoban
* @fileName Box.java
* @date : 3/13/2018
* @author : 
*/

package game;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Dobozokat reprezentál a játékban amelyeket lehet tologatni
 *
 */
public class Box extends Thing {
	
	private boolean onStorageArea;
	private Map<Direction, Boolean> pushableDirections;
	
	public Box()
	{
		super();
		onStorageArea=false;
		pushableDirections = new TreeMap<Direction, Boolean>();
		pushableDirections.put(Direction.UP, true);
		pushableDirections.put(Direction.DOWN, true);
		pushableDirections.put(Direction.LEFT, true);
		pushableDirections.put(Direction.RIGHT, true);
	}
	/**
	 * Akkor hívódikmeg ha Boxot el akarják tolni, meghívja a következő field getPushHereBy-ját
	 * @param pusher Player referenciája aki tolja
	 * @param dir	irány amerre tolják
	 * @param strength	még megmaradt erő
	 * @return a tolás után megmarat erő
	 */
	@Override
	public int slideBy(Player pusher, Direction dir, int strength) {
		
		return super.slideBy(pusher, dir, strength);
	}
	/**
	 * Beállítja a Box új Fieldjét
	 * @param newField az új Field referenciája
	 */
	@Override
	public void setNewField(Field newField) {		
		
		this.getCurrentField().remove(this); 	// Töröljük az ide mutató referenciát a jelenlegi field-rol.
		this.setField(newField);				// Új field beállítása.
		newField.set(this);						// A box bekötéseaz új field-re.
		calculatePushable();
	}
	/**
	 * megöli a Boxot
	 */
	@Override
	public void die()
	{		
		super.die();
	}
	/**
	 * a kiíráshoz szükséghez karaktert adja vissza
	 * @return a kiíráshoz szükséges karakter
	 */
	@Override
	public String MatrixElement() {				//kirajzolás a konzolra
		return "■";
	}
	public boolean getOnStorageArea() {
		return onStorageArea;
	}
	public void setOnStorageArea(boolean onStorageArea) {
		this.onStorageArea = onStorageArea;
	}
	
	public boolean getMoveable() {
		return true;
	}
	
	/**
	 * Kiszámolja, hogy tovább tolható-e a doboz
	 */
	public void calculatePushable() {
		Set<Direction> dirs = pushableDirections.keySet();
		
		for (Direction d : dirs) {
			
		}
		
		if (allWayFalse()) System.out.println("Nem mozdítható!!!");	// Ezt kell majd vizsgálni a boxokra!
	}
	
	
	public void setPushableMapValue(Direction key, boolean value) {
		pushableDirections.replace(key, value);
	}
	public Map<Direction, Boolean> getPushableDirections() {
		return pushableDirections;
	}
	
	private boolean allWayFalse() {
		Collection<Boolean> values = pushableDirections.values();
		boolean all = false;
		for (Boolean v : values) {
			if (v != false) all = true;
			
		}
		return !all;
	}
	
	
	///*****************
	
	
	

}
