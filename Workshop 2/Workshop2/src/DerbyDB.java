import java.sql.*;



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
