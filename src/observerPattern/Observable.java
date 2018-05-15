package observerPattern;

/**
 * A megfigyelhető objektumok interfésze
 * @author ferko
 *
 */
public interface Observable {
	/**
	 * Meghívja az observer-ek report metódusát
	 */
	public void reportToObservers();
	
	/**
	 * Felvétel az értesítendő objektumok listájábal
	 * @param obs felvévendő objektum
	 */
	public void register(Observer obs);
	
	/**
	 * Törlés az értesítendő objektumok listájából
	 * @param obs leregisztrálandó objekum
	 */
	public void unregister(Observer obs);
}
