package javagroupproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Shuang
 */
public class createCSV {
        public static void createCSVFile() throws IOException, SQLException {
            File file = new File("temp10.csv");
            File file2 = new File("temp11.csv");
            if (!file.exists() ) {
                FileWriter fw2;
                try (FileWriter fw = new FileWriter("temp10.csv")) {
                    fw2 = new FileWriter("temp11.csv");
                    fw.write("salary, info\n");
                    fw2.write("salary, GPA\n");
                    Connection conn = Dbconnection.getConnection();
                    ResultSet rs = null;
                    //StringBuilder sb = null;
                    Statement stat = null;
                    stat = conn.createStatement();
                    rs = stat.executeQuery("select * from studentinfor.student2");
                    while(rs.next()) {
                        String GPA = rs.getString("GPA");
                        fw.write(rs.getString("salaryDegree") + ","
                                + rs.getString("educationfield") + " "
                                + rs.getString("Course") + " "
                                + rs.getString("PostOrUnder") + " "
                                /**
                                 * + rs.getString("age") + " "
                                 * + rs.getString("Gender") + " "
                                 * + rs.getString("Citizenship") + " "
                                 * + rs.getString("Typeofattendee") + " "
                                 * + rs.getString("CountryofBirth") + " "
                                 * + rs.getString("Languagespokenathome") + " "
                                 * + rs.getString("studentIArrivalyearinUSAnfocol") + " "
                                 * + rs.getString("greC") + " "
                                 * + rs.getString("satC") + " "
                                 * + rs.getString("gmatC") + " "
                                 * + rs.getString("Equitydata") + " " */
                                + rs.getString("Coursecompletionyear") + " "
                                + rs.getString("Highesteducationalattainment") + " "
                                + GPA + " "
                                + rs.getString("Modeofattendance") + " "
//                                + rs.getString("GraduateGrade") + " "
                                + "\n");
                        fw2.write(rs.getString("salary")  + "," + GPA + "\n");
                    }   }
            fw2.close();
        } 
        }
    
}
        
        

