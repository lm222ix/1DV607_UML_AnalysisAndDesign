package Model;

public class Member {

	// Required fields for Member class

	private String name;
	private String personalNumber;
	private int memberID;

	// Constructor

	public Member(String name, String pN, int id) {
		this.name = name;
		this.personalNumber = pN;
		this.memberID = id;
	}

	//Setter and Getters

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getPersonalNumber() {return personalNumber;}
	public void setPersonalNumber(String personalNumber) {this.personalNumber = personalNumber;}

	public int getId() {return memberID;}
	public void setId(int id) {this.memberID = id;}

	// Prints all of the current info about an instance of Member

	public String getInfo() {
		String info = "";
		info = "ID" + this.getId() + ": " + this.getName() + "-" + this.getPersonalNumber();
		return info;
	}

    // Only used for simplifying the readability while making querys in DerbyDB

	@Override
	public String toString() {
		return "(" + "'"+this.getName()+"'" + ", " + "'" + this.getPersonalNumber() + "'" + ", " + "'" + Integer.valueOf(this.getId()) + "'" + ")";
	}
}
