package javagroupproject;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;

/**
 *
 * @author lingyanjiang
 */
public class JFreeChartTest {
    //string to store url,username,password
    private static final String URL="jdbc:mysql://localhost:3306/jfdatabase";
    private static final String USER="root";
    private static final String PASSWORD="abcd";
    
    
    public static JDBCPieDataset connectDatabase() throws ClassNotFoundException, SQLException{
        JDBCPieDataset data = null;
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            data = new JDBCPieDataset(conn,"select gender, count(1) as numbers from jfdatabase.figure group by gender;");
        }
        return data;
    }
    
    
    public static ChartPanel generateChart() throws ClassNotFoundException, SQLException {
        PieDataset dataset;
        dataset = connectDatabase();

        JFreeChart chart;
        chart = ChartFactory.createPieChart(      
                "Mobile Sales",  // chart title
                dataset,        // data
                true,           // include legend
                true,
                false);
        ChartPanel p = new ChartPanel(chart);
        return p;
    }
    
    
}
