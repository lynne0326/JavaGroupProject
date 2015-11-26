/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagroupproject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author lingyanjiang
 */
public class texttest {
    public static String s = "=== Detailed Accuracy By Class ===\n" +
"\n" +
"               TP Rate   FP Rate   Precision   Recall  F-Measure   ROC Area  Class\n" +
"                 0.98      0.972      0.323     0.98      0.486      0.515    Medium\n" +
"                 0.015     0.006      0.368     0.015     0.029      0.511    Low\n" +
"                 0.031     0.003      0.792     0.031     0.059      0.533    NoPay\n" +
"                 0.006     0          0.75      0.006     0.012      0.505    Excellent\n" +
"                 0.019     0.005      0.378     0.019     0.036      0.511    High\n" +
"Weighted Avg.    0.328     0.315      0.497     0.328     0.182      0.517";
    
    public static void main(String[] args) {
//        System.out.println(s.indexOf("t"));
//        System.out.println(s.substring(s.indexOf("0")));
        
        ArrayList<Double> data = new ArrayList<>();

        s = s.substring(s.indexOf("0"));
        String [] temp = s.split(" ");
        for(int i=0;i<temp.length;i++){
            if(temp[i].startsWith("0")||temp[i].startsWith("1")) {
                data.add(Double.parseDouble(temp[i]));
            }  
        }
        
        for(double a:data)
            System.out.println(a);
        
        
    }
    
}
