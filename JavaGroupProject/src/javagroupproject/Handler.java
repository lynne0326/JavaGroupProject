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
 * This class is to handle JDBCDataset
 * @author lingyanjiang
 */
public class Handler {
    
    /**
     * This method is to create chart with particular data type
     * @param title chart title
     * @param chartType 
     * @param query sql query to extract data
     * @return chartPanel
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static ChartPanel getChart(String title,String chartType,String query) throws ClassNotFoundException, SQLException{
        //get dataset
        Dataset dataset = Dbconnection.connectDatabase(chartType, query);
        
        CategoryDataset categoryData;
        PieDataset pieData;
        XYDataset xyData;
        
        ChartPanel p = null;
        
        if(dataset instanceof JDBCPieDataset){
            //if pie set
            pieData = (PieDataset)dataset;
            p = JChart.generateChart(dataset, title, "pie");
        }
        //if xy data set
        else if(dataset instanceof JDBCXYDataset){
            xyData = (XYDataset)dataset;
            p = JChart.generateChart(dataset, title, "histogram");
        }
        //if category
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
    
    /**
     * This method is to get total records in database
     * @return 
     */
    public static int getTotalRecord() {
        return Dbconnection.connectDatabase(1);
    }
    
}
