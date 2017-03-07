import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * This class is an implementation of First-In-First-Out queues.
 * 
 * @author isawah-6
 *
 */

public class FIFO implements Queue{
	
	private int maxSize = 0;
	private ArrayList<Object> FIFOQueue = new ArrayList<Object>();

	/**
	 * Adds arg0 to FIFO queue
	 * 
	 * @param arg0
	 */
	public void add(Object arg0) {
		FIFOQueue.add(arg0);
		if(FIFOQueue.size() >= maxSize) {
			maxSize = FIFOQueue.size();
		} else {
			maxSize++;
		}
	}

	/**
	 * Returns the first object in the FIFO queue.
	 * Throws NoSuchElementException is queue is empty.
	 * @throws NoSuchElementException
	 */
	public Object first() throws NoSuchElementException {
		if(FIFOQueue.size() == 0) {
			throw new NoSuchElementException();
		}
		return FIFOQueue.get(0);
	}

	/**
	 * Returns true if FIFO queue is empty.
	 */
	public boolean isEmpty() {
		return FIFOQueue.isEmpty();
	}

	/**
	 * Returns the largest size that FIFO queue has had during its lifetime.
	 */
	public int maxSize() {
		return maxSize;
	}

	/**
	 * Removes the first element if FIFO queue and
	 * if empty, throws NoSuchElementException.
	 * @throws NoSuchElementException
	 */
	public void removeFirst() throws NoSuchElementException {
		if(FIFOQueue.size() == 0) {
			throw new NoSuchElementException();
		}
		FIFOQueue.remove(0);
	}

	/**
	 * Returns current size of FIFO queue.
	 */
	public int size() {
		return FIFOQueue.size();
	}
	
	/**
	 * Returns FIFO queue.
	 * @return FIFOQueue
	 */
	public ArrayList<Object> getQueue() {
		return FIFOQueue;
	}
	
	/**
	 * Returns String that shows what the queue contains.
	 */
	public String toString() {
		String message;
		message = "Queue: ";
		
		for(int elem = 0; elem < FIFOQueue.size(); elem++) {
			message += "(" + String.valueOf(this.FIFOQueue.get(elem)) + ") ";
		}
		
		return message;
	}
	
	/**
	 * Checks if "this" and "f" are the same. If "f" is not of type FIFO, throws ClassCastException.
	 * @param f
	 * @throws ClassCastException
	 */
	public boolean equals(Object f) throws ClassCastException {
		if(f instanceof FIFO == false) {
			throw new ClassCastException();
			
		} else {
			if(((FIFO) f).size() == this.size()) {
				for(int i = 0; i < ((FIFO) f).size(); i++) {
					if(((FIFO) f).getQueue().get(i) == null && FIFOQueue.get(i) == null) {
						continue;
					}
					if(FIFOQueue.get(i) == null && ((FIFO) f).getQueue().get(i) != null) {
						return false;
					}
					if(FIFOQueue.get(i) != null && ((FIFO) f).getQueue().get(i) == null) {
						return false;
					}
					if(((FIFO) f).getQueue().get(i) == FIFOQueue.get(i)) {
						return false;
					}
				}
			}else {
				return false;
			}
		}
		return true;
	}

}
