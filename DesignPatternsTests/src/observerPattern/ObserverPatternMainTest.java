package observerPattern;

/**
 * Observer implementation testing
 * @author David
 *
 */
public class ObserverPatternMainTest {
	
	/**
	 * Creates Observable object with Integer value. 
	 * If the value changes, the registered Observers will be notified by the NumberObservable instance.
	 * @param args
	 */
	public static void main(String[] args) {
		
		/** Test Observers to wait for notifications from Observable object that they are registered to. */
		SampleObserver testObserver1 = new SampleObserver("Observer 1");
		SampleObserver testObserver2 = new SampleObserver("Observer 2");
		SampleObserver testObserver3 = new SampleObserver("Observer 3");
		
		/** Observable object which notifies registered observers once the number has changed. */
		NumberObservable numberObservable = new NumberObservable(999);
		
		/** Adding the Observer instances to the Observable instance */
		numberObservable.addObserver(testObserver1);
		numberObservable.addObserver(testObserver2);
		numberObservable.addObserver(testObserver3);
		
		/** Test change of number from Observable */
		numberObservable.setNo(5);
	}
	
}
