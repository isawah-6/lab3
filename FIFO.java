import java.util.NoSuchElementException;
import java.util.ArrayList;

public class FIFO implements Queue{
	
	private int maxSize = 0;
	private ArrayList<Object> FIFOQueue = new ArrayList<Object>();

	public void add(Object arg0) {
		FIFOQueue.add(arg0);
		if(FIFOQueue.size() >= maxSize) {
			maxSize = FIFOQueue.size();
		} else {
			maxSize++;
		}
	}

	public Object first() throws NoSuchElementException {
		if(FIFOQueue.size() == 0) {
			throw new NoSuchElementException();
		}
		return FIFOQueue.get(0);
	}

	public boolean isEmpty() {
		return FIFOQueue.isEmpty();
	}

	public int maxSize() {
		return maxSize;
	}

	public void removeFirst() throws NoSuchElementException {
		if(FIFOQueue.size() == 0) {
			throw new NoSuchElementException();
		}
		FIFOQueue.remove(0);
	}

	public int size() {
		return FIFOQueue.size();
	}
	
	public ArrayList<Object> getQueue() {
		return FIFOQueue;
	}
	
	public String toString() {
		String message;
		message = "Queue: ";
		
		for(int elem = 0; elem < FIFOQueue.size(); elem++) {
			message += "(" + String.valueOf(elem) + ") ";
		}
		
		return message;
	}
	
	public boolean equals(Object f) throws ClassCastException {
		if(f instanceof FIFO == false) {
			throw new ClassCastException();
			
		} else if(f instanceof FIFO && ((FIFO) f).size() == this.size()) {
			for(int i = 0; i < ((FIFO) f).size(); i++) {
				if(((FIFO) f).getQueue().get(i) != FIFOQueue.get(i)) {
					return false;
				}
			}
		}
		return true;
	}

}
