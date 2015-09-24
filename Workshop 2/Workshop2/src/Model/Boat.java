package Model;

public class Boat {
	private enum Type{
		Sailboat, 
		Motorsailer,
		kayakCanoe,
		Other;
	}
	private Type type;
	private double length;
	
	
	public Boat(double length, Type type) {
		this.length = length;
		this.type = type;
	}
	
}
