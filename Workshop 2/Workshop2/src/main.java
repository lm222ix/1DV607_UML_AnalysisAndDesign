import Model.Boat;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Model.IDTracker idt = new Model.IDTracker();
		Model.Member a = new Model.Member("Ludde", "9409251171",idt.assignID());
		Model.Member b = new Model.Member("cpjohan", "9805231337",idt.assignID());

		DerbyDB db = new DerbyDB();
		db.createDB();
		//db.createMemberTable();
		//db.insertMember(a);
		db.insertMember(b);
		db.print(db.query("Member"));
	}
}
