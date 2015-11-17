package javagroupproject;

import java.sql.SQLException;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.jfree.data.jdbc.JDBCXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 * This class is to handle 
 * @author lingyanjiang
 */
public class Handler {
    
    public static ChartPanel getChart(String chartType,String query) throws ClassNotFoundException, SQLException{
        //get dataset
        Dataset dataset = Dbconnection.connectDatabase(chartType, query);
        
        CategoryDataset categoryData;
        PieDataset pieData;
        XYDataset xyData;
        
        ChartPanel p = null;
        
        if(dataset instanceof JDBCPieDataset){
            pieData = (PieDataset)dataset;
            p = JChart.generateChart(dataset, "piechart", "pie");
        }
        else if(dataset instanceof JDBCXYDataset){
            xyData = (XYDataset)dataset;
            p = JChart.generateChart(dataset, "xychart", "xy");
        }
        else if(dataset instanceof JDBCCategoryDataset){
            categoryData = (CategoryDataset)dataset;
            p = JChart.generateChart(dataset, "categorychart", "category");
        }
        
        return p;
        
            
    }
    
}
