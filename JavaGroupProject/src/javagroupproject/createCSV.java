/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagroupproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 *
 * @author Shuang
 */
public class createCSV {
        public static void createCSVFile() throws IOException, SQLException {
            File file = new File("temp10.csv");
            if (!file.exists()) {
            FileWriter fw = new FileWriter("temp10.csv");
            
            fw.write("salary, info\n");
            
            Connection conn = Dbconnection.getConnection();
            ResultSet rs = null;
            //StringBuilder sb = null;
            Statement stat = null;
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from studentinfor.student2");
            while(rs.next()) {
                /**
                StringBuilder sb = null;
                for (int i=1; i < 10; i++) {
                    sb.append(rs.getString(i));
                    sb.append(" ");
                    System.out.println(sb);
                }
                for (int i=12; i < 25; i++) {
                    sb.append(rs.getString(i));
                    sb.append(" ");
                }
                */
                fw.write(rs.getString(25) + "," 
                        + rs.getString("educationfield") + " " 
                        + rs.getString("Course") + " " 
                        + rs.getString("PostOrUnder") + " " 
                        /**
                        + rs.getString("age") + " " 
                        + rs.getString("Gender") + " " 
                        + rs.getString("Citizenship") + " " 
                        + rs.getString("Typeofattendee") + " " 
                        + rs.getString("CountryofBirth") + " " 
                        + rs.getString("Languagespokenathome") + " " 
                        + rs.getString("studentIArrivalyearinUSAnfocol") + " " 
                        + rs.getString("greC") + " " 
                        + rs.getString("satC") + " " 
                        + rs.getString("gmatC") + " " 
                        + rs.getString("Equitydata") + " " */
                        + rs.getString("Coursecompletionyear") + " "
                        + rs.getString("Highesteducationalattainment") + " " 
                        + rs.getString("GPA") + " " 
                        + rs.getString("Modeofattendance") + " " 
                        + rs.getString("GraduateGrade") + " " 
                        + "\n");
                //sb = null;
            }
            fw.close();
            System.out.println("create successful");
        } 
        }
        
}
        
        

