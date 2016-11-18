package observerPattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Observer sample which is supposed to be notified when Observable has changed its number.
 * It then refreshes its own int "actNumber" accordingly.
 * @author David
 *
 */
public class SampleObserver implements Observer{

	private String observerName;
	private int actNumber = 0;
	
	public SampleObserver(String obsName) {
		this.observerName = obsName;
	}
	
	/**
	 * Different Observer implementations could do different
	 * actions with the received notification.
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		int newNumber = ((NumberObservable) arg0).getNo();
		System.out.println(observerName + " has received the change. The number is now " + newNumber + ".");
		setActNumber(newNumber);
	}
	
	public int getActNumber() {
		return this.actNumber;
	}
	
	public void setActNumber(int num) {
		this.actNumber = num;
	}

}
