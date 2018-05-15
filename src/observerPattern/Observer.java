package observerPattern;

/**
 * Megfigyelő objektum interfésze
 * @author ferko
 *
 */
public interface Observer {
	
	/**
	 * Ez a metódus hívódik ha egy megfigyelt objektum értesítést küld
	 * @param o a megfigyelt objektum
	 */
	public void report(Observable o);
}
