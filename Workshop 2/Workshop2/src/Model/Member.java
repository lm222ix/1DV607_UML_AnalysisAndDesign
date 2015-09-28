package Model;

public class Member {

	private String name;
	private String personalNumber;
	private int id;

	
	public Member(String name, String pN, int id) {
		this.name = name;
		this.personalNumber = pN;
		this.id = id;
	}


	//Set&Gets
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getPersonalNumber() {return personalNumber;}
	public void setPersonalNumber(String personalNumber) {this.personalNumber = personalNumber;}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	//
	public String getInfo() {
		String info = "";
		info = "ID" + this.getId() + ": " + this.getName() + "-" + this.getPersonalNumber();
		return info;
	}
}
