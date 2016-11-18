package observerPattern;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Creates Observable object with Integer value. 
 * If the value changes, the registered Observers will be notified by the NumberObservable instance.
 */
public class ObserverUnitTest {

	
	/** Observable */
	private NumberObservable numberObservable;
	
	/**
	 * Keeping the same Observable instance for testing purposes.
	 */
	@Before
	public void before() {
		/** Observable object which notifies registered observers once the number has changed. */
		this.numberObservable = new NumberObservable(999);
	}
	
	
	/**
	 * Single Observer test
	 */
	@Test
	public void testNumberChangedNotificationSingleObserver() {
		/** Test Observers to wait for notifications from Observable object that they are registered to. */
		SampleObserver testObserver1 = new SampleObserver("Observer 1");
		
		/** Adding the Observer instance to the Observable instance */
		numberObservable.addObserver(testObserver1);
		
		/** Test change of number from Observable */
		numberObservable.setNo(5);
		
		/** Number should be 5 in the Observer (variable actNum) */
		assertEquals(5, testObserver1.getActNumber());
	}
	
	/**
	 * Multiple Observers test
	 */
	@Test(timeout = 4)
	public void testNumberChangedNotificationMultipleObservers() {
		/** Test Observers to wait for notifications from Observable object that they are registered to. */
		SampleObserver testObserver1 = new SampleObserver("Observer 1");
		SampleObserver testObserver2 = new SampleObserver("Observer 2");
		SampleObserver testObserver3 = new SampleObserver("Observer 3");
		
		/** Adding the Observer instances to the Observable instance */
		numberObservable.addObserver(testObserver1);
		numberObservable.addObserver(testObserver2);
		numberObservable.addObserver(testObserver3);
		
		/** Test change of number from Observable */
		numberObservable.setNo(5);
		/** Number should be 5 in the Observer (variable actNum) */
		assertEquals(5, testObserver1.getActNumber());

		/** Observer 2 */
		numberObservable.setNo(555);
		assertEquals(555, testObserver2.getActNumber());
		
		/** Observer 3 */
		numberObservable.setNo(55555);
		assertEquals(55555, testObserver3.getActNumber());
		
	}
	
	/**
	 * Reset Observable number
	 */
	@After
	public void after() {
		this.numberObservable = new NumberObservable(0);
	}
	
}
