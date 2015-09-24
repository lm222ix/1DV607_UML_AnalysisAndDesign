package Model;

public class IDTracker {
	
	private int counter;
	public IDTracker() {
		counter = 0;
	}
	public int assignID() {
		counter++;
		return this.counter;
	}
}

