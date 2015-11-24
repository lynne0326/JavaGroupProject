package javagroupproject;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartPanel;

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
}
