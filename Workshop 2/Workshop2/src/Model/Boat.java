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

	private int memberID;

    private int boatID;

	public Boat(double length, Type type) {
		this.length = length;
		this.type = type;
	}

    public Type getType(){
        return this.type;
    }

    public double getLength(){
        return this.length;
    }

    @Override
    public String toString() {
        return "(" + "'"+this.getType()+"'" + ", " + "'" + this.getLength() + "'" + ", " + "'" + String.valueOf(this.getLength()) + "'" + ")";
    }
	
}