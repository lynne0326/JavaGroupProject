package javagroupproject;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.jfree.data.general.Dataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.jfree.data.jdbc.JDBCXYDataset;

/**
 *
 * @author Shuang
 */
public class Dbconnection {
    //string to store url,username,password
    private static final String URL="jdbc:mysql://mydatabase.cwhndt08kykb.us-west-2.rds.amazonaws.com:3306/studentinfor";
    private static final String USER="lynne";
    private static final String PASSWORD="abcd1234";
    
    /**
     * Returns the dataset under the query from database.
     * @param dataSetType
     * @param query
     * @return Returns the dataset under the query from database.
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Dataset connectDatabase(String dataSetType, String query) throws ClassNotFoundException, SQLException{
        Dataset data = null;
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            switch(dataSetType) {
                case "pie":
                    data = new JDBCPieDataset(conn, query);
                    break;
                case "xy":
                    data = new JDBCXYDataset(conn, query);
                    break;
                case "category":
                    data = new JDBCCategoryDataset(conn, query);
                    break;   
            }

        }
        return data;
    }
    
}
