import Model.Boat;

import javax.xml.transform.Result;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		//Model.IDTracker idt = new Model.IDTracker();
		Model.Member a = new Model.Member("LUDDE", "9409251171");
		Model.Member b = new Model.Member("cpjohan", "9805231337");
		Model.Boat c = new Model.Boat(a, 100, Boat.MOTORSAILER);

		DerbyDB db = new DerbyDB();
		db.createDB();
      	//db.createMemberTable();
		//db.createBoatTable();

		//db.dropTable("Member");
		//db.dropTable("BOAT");
		//db.createMember(a);
		//db.createBoat(c);
		//db.createMember(b);
		//db.print(db.query("Member"));
		int val =  ((Number) db.getMemberID(a).getObject(1)).intValue(); // <---- TODO
		System.out.println(val);
		db.print(db.getMemberID(a));
		//db.print(db.query("Boat"));
	}
}
