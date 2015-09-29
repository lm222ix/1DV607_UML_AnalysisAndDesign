import Model.Boat;
import Model.Member;


import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;


/**
 * Created by Ludde on 2015-09-24.
 */
public class DerbyDB {

    public final String DRIVER;
    public final String JDBC_URL;

    static Connection connection;

    public DerbyDB() {
        DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        JDBC_URL = "jdbc:derby:RegisterDB;create=true";

        connection = null;
    }

    public void createDB() throws SQLException, ClassNotFoundException
    {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(JDBC_URL);
    }

    public void createMemberTable() {
        try
        {
            connection.createStatement().execute("" +
                    "create table MEMBER(Name varchar(40), " +
                    "PersonalNumber varchar(12), " +
                    "id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1))");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropMemberTable() {
        try {
            connection.createStatement().execute("DROP TABLE" + "MEMBER");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createMember(Member member)

    {
        try {
            //questions marks mean they are anonymous
            connection.createStatement().execute("Insert into MEMBER (Name, PersonalNumber) values " + member.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createBoat(Boat boat) {
        try {
            connection.createStatement().execute("Insert into BOAT values" + boat.toString());
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    BOILER PLATE SHIT, DON'T WORRY ABOUT THIS
     */


    public ResultSet query(String table) throws SQLException
    {
        String query = "select * from " +  table;
        return connection.createStatement().executeQuery(query);
    }

    public void print(ResultSet resultSet) throws SQLException
    {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int columns = resultSetMetaData.getColumnCount();
        //		System.out.println(columns);

        for (int i = 1; i<= columns; i++)
        {
            System.out.format("%20s", resultSetMetaData.getColumnName(i) + "  |  ");

        }
        while (resultSet.next())
        {
            System.out.println();
            for (int i = 1; i <= columns; i++)
            {
                System.out.format("%20s", resultSet.getString(i) + "  |  ");
            }
        }
        System.out.println();
    }
}
