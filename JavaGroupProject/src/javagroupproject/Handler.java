package javagroupproject;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.jfree.data.jdbc.JDBCXYDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.data.xy.XYDataset;
/**
 * This class is to handle 
 * @author lingyanjiang
 */
public class Handler {
    
    public static ChartPanel getChart(String title,String chartType,String query) throws ClassNotFoundException, SQLException{
        //get dataset
        Dataset dataset = Dbconnection.connectDatabase(chartType, query);
        
        CategoryDataset categoryData;
        PieDataset pieData;
        XYDataset xyData;
        
        ChartPanel p = null;
        
        if(dataset instanceof JDBCPieDataset){
            pieData = (PieDataset)dataset;
            p = JChart.generateChart(dataset, title, "pie");
        }
        else if(dataset instanceof JDBCXYDataset){
            xyData = (XYDataset)dataset;
            p = JChart.generateChart(dataset, title, "histogram");
        }
        
        else if(dataset instanceof JDBCCategoryDataset){
            categoryData = (CategoryDataset)dataset;
            if(chartType.equals("categoryx")){
                p = JChart.generateChart(dataset, title, "categoryx");
            }
            else if(chartType.equals("categoryy")){
                p = JChart.generateChart(dataset, title, "categoryy");
            }
            else if(chartType.equals("line")) {
                p = JChart.generateChart(dataset, title, "line");
            }
        
        }
        
        return p;
        
            
    }
    
    public static int getTotalRecord() {
        return Dbconnection.connectDatabase(1);
    }
    
}
