package Model;

public class Boat {

	public static final String SAILBOAT = "Sailboat";
	public static final String MOTORSAILER = "Motorsailer";
	public static final String KAYAKCANOE = "kayakCanoe";
	public static final String OTHER = "Other";

    private String type;

	private double length;

	private int memberID;

    private int boatID;

	public Boat(Member owner, double length, String type) {
		this.length = length;
		this.type = type;
		this.memberID = owner.getId();
	}

    public String getType(){
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
        return "(" + "'"+ this.getType()+"'" + "," +  "'" + String.valueOf(this.getLength()) + "'" + "," + "'" + String.valueOf(this.getMemberID()) + "'" + ")";
    }
	
}