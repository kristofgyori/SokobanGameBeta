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
	/**
	 * boolean ami tartalmazza, hogy a box éppen storagearea-n van-e
	 */
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
	 * Visszaadja hogy a box éppen StorageArea-n van-e
	 * @return
	 */
	public boolean getOnStorageArea()
	{
		return onStorageArea;
	}
	/**
	 * Beállítja hogy a box éppen StorageArea-n van-e
	 * @return
	 */
	public void setOnStorageArea(boolean on)
	{
		onStorageArea=on;
	}
	/**
	 * megöli a Boxot
	 */
	@Override
	public void die()
	{		
		super.die();
	}

}
