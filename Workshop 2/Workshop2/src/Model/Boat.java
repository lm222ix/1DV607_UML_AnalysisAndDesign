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

	public double getLength() {
		return this.length;
	}
	public Type getType() {
		return this.type;
	}


	public String toString() {
		return "(" + "'" + this.getLength()+"'" + ", " + "'" + this.getType() + "'" + ")";

	}
	
}
