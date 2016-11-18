package observerPattern;

import java.util.Observable;

/**
 * If the number changes, the registered observers will be notified.
 * @author David
 *
 */
public class NumberObservable extends Observable{
	
	private int no = 0;
	
	/**
	 * Init with a number.
	 * @param n
	 */
	public NumberObservable(int n) {
		this.no = n;
	}
	
	/**
	 * Notify observers once a change has been detected.
	 * @param n
	 */
	public void setNo(int n) {
		this.no = n;
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getNo() {
		return this.no;
	}
	
}
