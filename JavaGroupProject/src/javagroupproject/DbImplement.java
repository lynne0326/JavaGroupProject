package javagroupproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javagroupproject.JChart.getSupplier;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.data.xy.DefaultXYZDataset;

/**
 *
 * @author lingyanjiang
 */
public class DbImplement {
    public static ChartPanel genderByYear(String year) {
        ChartPanel p = null;
        try {
            p = Handler.getChart("Number of students by gender","pie", "SELECT Gender,count(1) FROM studentinfor.student2 where year = "+year+" group by Gender;");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public static ChartPanel courseByYear(String year) {
        try {
            return Handler.getChart("Number of students by course","categoryx", "SELECT Course,count(1) as 'Number of course' FROM studentinfor.student2 where "+ year +" group by Course;");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ChartPanel citizenshipByYear(String year){
        ChartPanel p = null;
        try{
            p = Handler.getChart("Number of students by citizenship","categoryy", "SELECT Citizenship,count(1) as 'Number of Student' FROM studentinfor.student2 where Year = "+year+" group by Citizenship;");
        }catch(ClassNotFoundException | SQLException ex){
         Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    
    }
public static ChartPanel GMATByYear(String year){
        ChartPanel p = null;
        try{
                java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://mydatabase.cwhndt08kykb.us-west-2.rds.amazonaws.com:3306/studentinfor", 
                    "lynne", "abcd1234");
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs1 = stmt.executeQuery("SELECT gmatC FROM studentinfor.student2 where Year = "+year+" AND Basisforadmission = 'GMAT';");
                    List list1 = new ArrayList();
                    while(rs1.next())
                    {
                         
                     list1.add(rs1.getInt(1));    
                    }
                    p = boxPlot(list1,"GMAT",year);
            
        }catch(SQLException ex){
         Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
public static ChartPanel GREByYear(String year){
        ChartPanel p = null;
        try{
                java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://mydatabase.cwhndt08kykb.us-west-2.rds.amazonaws.com:3306/studentinfor", 
                    "lynne", "abcd1234");
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs1 = stmt.executeQuery("SELECT greC FROM studentinfor.student2 where Year = "+year+" AND Basisforadmission = 'GRE';");
                    List list1 = new ArrayList();
                    while(rs1.next())
                    {
                         
                     list1.add(rs1.getInt(1));    
                    }
                    p = boxPlot(list1,"GRE",year);
            
        }catch(SQLException ex){
         Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
public static ChartPanel SATByYear(String year){
        ChartPanel p = null;
        try{
                java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://mydatabase.cwhndt08kykb.us-west-2.rds.amazonaws.com:3306/studentinfor", 
                    "lynne", "abcd1234");
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs1 = stmt.executeQuery("SELECT satC FROM studentinfor.student2 where Year = "+year+" AND Basisforadmission = 'SAT';");
                    List list1 = new ArrayList();
                    while(rs1.next())
                    {
                         
                     list1.add(rs1.getInt(1));    
                    }
                    p = boxPlot(list1,"SAT",year);
            
        }catch(SQLException ex){
         Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
public static ChartPanel SalaryByYear(String year){
        ChartPanel p = null;
        try{
                java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://mydatabase.cwhndt08kykb.us-west-2.rds.amazonaws.com:3306/studentinfor", 
                    "lynne", "abcd1234");
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs1 = stmt.executeQuery("SELECT Salary FROM studentinfor.student2 where Year = "+year+";");
                    List list1 = new ArrayList();
                    while(rs1.next())
                    {
                         
                     list1.add(rs1.getInt(1));    
                    }
                    p = boxPlot(list1,"Salary",year);
            
        }catch(SQLException ex){
         Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
/**
 * 
 * @param list
 * @param basis
 * @param year
 * @return 
 */
    public static ChartPanel boxPlot(List list,String basis,String year)
    {
            ChartPanel p = null;
            DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
            dataset.add(list,basis, year);
            JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(basis +" by Year","","",dataset, true);
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            BoxAndWhiskerRenderer renderer = (BoxAndWhiskerRenderer)plot.getRenderer();
            renderer.setFillBox(false);
            renderer.setMaximumBarWidth(0.1);
            CategoryAxis domainAxis = plot.getDomainAxis();
            chart.setBorderVisible(false);
            chart.setBackgroundPaint(null);
            plot.getRenderer().setSeriesPaint(0, new Color(59,189,211));
            p = new ChartPanel(chart);   
            p.setPreferredSize(new Dimension(400, 300));
            p.setOpaque(false); 
            return p;
    }
public static ChartPanel naiveBayes() throws IOException
{
        ChartPanel panel = null;
        JFreeChart chart = null;

        ArrayList<Double> data = WekaData.classify();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String[] category = {"Medium","Low","NoPay","Excellent","High"};
        String[] value = {"TP Rate","FP Rate","Precision","Recall","F-Measure","ROC Area"};
        int k =0;
        for(int i = 0; i < 5;i++)
            for(int j = 0; j < 6; j++)
            {
                double v = data.get(k);
                k++;
                dataset.addValue(v,category[i] ,value[j]);
            }
        chart = ChartFactory.createBarChart(
                "NaiveBayes on Slary level",null,null,
                (CategoryDataset)dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundAlpha(0.5f);
        plot.setDrawingSupplier(getSupplier());
        BarRenderer customBarRenderer2 = (BarRenderer) plot.getRenderer();
        customBarRenderer2.setBarPainter( new StandardBarPainter() );
        customBarRenderer2.setItemMargin(-0.01);
        chart.setBorderVisible(false);
        chart.setBackgroundPaint(null);
        panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(700, 350));
        return panel;
}   

public static ChartPanel clusterBubble(String s){
        ChartPanel panel = null;
        JFreeChart chart = null;
        
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        
        ArrayList<Double> dataList = WekaData.cluster(s);
       
        double[] xVal = {0,1};
        
        double[] yVal = {dataList.get(4), dataList.get(5)};
        double[] zVal = {dataList.get(1)/16000, dataList.get(2)/16000};
        double[][] bubbleVal = {yVal, xVal, zVal};
        
        dataset.addSeries("Number of Students", bubbleVal);
        
        chart = ChartFactory.createBubbleChart(
                "Cluster Analysis for Salary", " Salary ", "Cluster Type", dataset, PlotOrientation.HORIZONTAL, true, true, true);
        XYPlot xyplot = ( XYPlot )chart.getPlot( );
        xyplot.setBackgroundAlpha(0.5f);
        xyplot.setDrawingSupplier(getSupplier());
        XYItemRenderer xyitemrenderer = xyplot.getRenderer( );
        xyitemrenderer.setSeriesPaint( 0 , Color.blue );
        
        //y
        NumberAxis numberaxis = ( NumberAxis )xyplot.getDomainAxis( );
        numberaxis.setLowerMargin( 0.2 );
        numberaxis.setUpperMargin( 0.5 );
        

        
        // x
        ValueAxis numberaxis1 = new SymbolAxis(" ", new String[]{"Type 1", "Type 2"});
        
        
        //NumberAxis numberaxis1 = ( NumberAxis )xyplot.getRangeAxis( );
        numberaxis1.setLowerMargin( 0.8 );
        numberaxis1.setUpperMargin( 0.9 );
        xyplot.setRangeAxis(numberaxis1);
        /*
        TickUnits stdUnits = new TickUnits();
        DecimalFormat formatter = new DecimalFormat("##,###");
        stdUnits.add(new NumberTickUnit(10,formatter));
        stdUnits.add(new NumberTickUnit(20,formatter));
        numberaxis1.setStandardTickUnits(stdUnits);
        **/
 
        
        chart.setBorderVisible(false);
        chart.setBackgroundPaint(null);          
        panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(700, 400));
        
    
    return panel;
    }
  
}
