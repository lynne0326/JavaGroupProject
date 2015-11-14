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
        
        if(dataset instanceof JDBCPieDataset){
            pieData = (PieDataset)dataset;
            //call method in jfreechart
            //get pie chart
            //return pie chart
        }
        else if(dataset instanceof JDBCXYDataset){
            xyData = (XYDataset)dataset;
            //call method in jfreechart
            //get xy chart
            //return xy chart
        }
        else if(dataset instanceof JDBCCategoryDataset){
            categoryData = (CategoryDataset)dataset;
            //call method in jfreechart
            //get category chart
            //return category chart
        }
        
        return null;
        
            
    }
    
}
