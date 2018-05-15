/**
* @Project : KillerSokoban
* @fileName Box.java
* @date : 3/13/2018
* @author : 
*/

package game;
/**
 * Dobozokat reprezentál a játékban amelyeket lehet tologatni
 *
 */
public class Box extends Thing {
	
	private boolean onStorageArea;
	
	
	public Box()
	{
		super();
		onStorageArea=false;
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

}
