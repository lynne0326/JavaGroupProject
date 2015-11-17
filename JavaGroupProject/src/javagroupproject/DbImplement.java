/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            p = Handler.getChart("pie", "SELECT gender,count(1) FROM studentinfor.student where year = "+year+" group by gender;");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public static ChartPanel scoreByYear(String year) {
        try {
            return Handler.getChart("category", "SELECT gender,count(1) FROM studentinfor.student group by gender;");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ChartPanel citizenshipByYear(String year){
        ChartPanel p = null;
        try{
            p = Handler.getChart("category", "SELECT Citizenship,count(1) as 'Number of Student' FROM studentinfor.student where Year = "+year+" group by Citizenship;");
        }catch(ClassNotFoundException | SQLException ex){
         Logger.getLogger(DbImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    
    }
}
