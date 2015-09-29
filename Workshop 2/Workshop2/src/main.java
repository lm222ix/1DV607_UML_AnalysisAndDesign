import Model.Boat;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		//Model.IDTracker idt = new Model.IDTracker();
		Model.Member a = new Model.Member("Ludde", "9409251171");
		Model.Member b = new Model.Member("cpjohan", "9805231337");

		DerbyDB db = new DerbyDB();
		db.createDB();
        db.createMemberTable();
		db.dropMemberTable();
		//db.createMember(a);
		//db.createMember(b);
		db.print(db.query("Member"));
	}
}
