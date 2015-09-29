package Model;

public class Boat {
    public enum Type{
		String Sail_Boat = "Sailboat",
		Motorsailer,
		kayakCanoe,
		Other;
	}

    private Type type;

	private double length;

	private int memberID;

    private int boatID;

	public Boat(Member owner, double length, Type type) {
		this.length = length;
		this.type = type;
		this.memberID = owner.getId();
	}

    public Type getType(){
        return this.type;
    }

    public double getLength(){
        return this.length;
    }
	public int getMemberID() {
		return this.memberID;
	}


    @Override
    public String toString() {
        return "(" + "'"+ this.getType()+"'" + "," +  "'" + String.valueOf(this.getLength()) + "'" + "'" + String.valueOf(this.getMemberID()) + "'" + ")";
    }
	
}