package javagroupproject;

import java.awt.Dimension;
import java.awt.Font;
import org.jfree.chart.ChartFactory;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

/**
 *
 * @author lingyanjiang
 */
public class DbImplement {
    public static ChartPanel genderByYear(String year) {
        ChartPanel p = null;
        try {
            p = Handler.getChart("Number of students by gender","pie", "SELECT gender,count(1) FROM studentinfor.student where year = "+year+" group by gender;");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public static ChartPanel courseByYear(String year) {
        try {
            return Handler.getChart("Number of students by course","categoryx", "SELECT Course,count(1) as 'Number of course' FROM studentinfor.student where "+ year +" group by course;");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ChartPanel citizenshipByYear(String year){
        ChartPanel p = null;
        try{
            p = Handler.getChart("Number of students by citizenship","categoryy", "SELECT Citizenship,count(1) as 'Number of Student' FROM studentinfor.student where Year = "+year+" group by Citizenship;");
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
                    ResultSet rs1 = stmt.executeQuery("SELECT gmatC FROM studentinfor.student where Year = "+year+" AND Basisforadmission = 'GMAT';");
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
                    ResultSet rs1 = stmt.executeQuery("SELECT greC FROM studentinfor.student where Year = "+year+" AND Basisforadmission = 'GRE';");
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
                    ResultSet rs1 = stmt.executeQuery("SELECT satC FROM studentinfor.student where Year = "+year+" AND Basisforadmission = 'SAT';");
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
            
            p = new ChartPanel(chart);   
            p.setPreferredSize(new Dimension(400, 300));
            p.setOpaque(false); 
            return p;
    }
}
