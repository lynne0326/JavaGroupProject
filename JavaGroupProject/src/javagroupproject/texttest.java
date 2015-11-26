/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagroupproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lingyanjiang
 */
public class texttest {

    public static String s = "kMeans\n"
            + "======\n"
            + "\n"
            + "Number of iterations: 6\n"
            + "Within cluster sum of squared errors: 89.3668521146179\n"
            + "Missing values globally replaced with mean/mode\n"
            + "\n"
            + "Cluster centroids:\n"
            + "                         Cluster#\n"
            + "Attribute    Full Data          0          1\n"
            + "                (5006)     (3348)     (1658)\n"
            + "============================================\n"
            + "salary      40318.3632 58149.7266  4311.4845\n"
            + "\n"
            + "";

    public static void main(String[] args) {
//        System.out.println(s.indexOf("Full Data"));
//        System.out.println(s.substring(s.indexOf("("), s.lastIndexOf(")")+1));
        
        ArrayList<Double> data = new ArrayList<>();
        
        String a = s.substring(s.indexOf("("), s.lastIndexOf(")"));
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(a);
        while (m.find()) {
            data.add(Double.parseDouble(m.group(0)));
        }
        
        System.out.println(s.substring(s.indexOf("===============")));
        String b =s.substring(s.indexOf("==============="));
        String [] temp = b.split(" ");
        int count=0;
        for(int i=0;i<temp.length;i++){
            if(temp[i].contains(".")){
                data.add(Double.parseDouble(temp[i]));
            }
        }
        
        for(Double d:data)
            System.out.println(d);


//        s = s.substring(s.indexOf("Full Data"));
//        String [] temp = s.split("\\(");
//        for(String s:temp)
//            System.out.println(s);
//        ArrayList<Double> data = new ArrayList<>();
//
//        s = s.substring(s.indexOf("0"));
//        String [] temp = s.split(" ");
//        for(int i=0;i<temp.length;i++){
//            if(temp[i].startsWith("0")||temp[i].startsWith("1")) {
//                data.add(Double.parseDouble(temp[i]));
//            }  
//        }
//        
//        for(double a:data)
//            System.out.println(a);
    }

}
