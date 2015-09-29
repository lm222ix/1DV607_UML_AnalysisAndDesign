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
            connection.createStatement().execute("create table MEMBER(Name varchar(40), PersonalNumber varchar(12), ID varchar(3))");
          //  connection.createStatement().execute("create table TIMELINES(Title varchar(50), StartDate varchar(16), EndDate varchar (16), Duration varchar(160))");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertMember(Member member)

    {
        String query = member.toString();
        try {
            //questions marks mean they are anonymous
            connection.createStatement().execute("Insert into MEMBER values " + query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



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
