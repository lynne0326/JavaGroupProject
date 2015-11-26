/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagroupproject;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javagroupproject.texttest.s;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibSVM;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

/**
 *
 * @author Shuang
 */
public class WekaData {


    
    static Instances dataSet;
    static String result;
    
    public static Instances csv2arff() {
        
        try {
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File ("temp10.csv"));
            dataSet = loader.getDataSet();
            dataSet.setClassIndex(0);
            
            ArffSaver saver = new ArffSaver();
            saver.setInstances(dataSet);
            File file = new File("test.arff");
            file.createNewFile();
            saver.setFile(file);
            saver.writeBatch();
        } catch (Exception ex) {
            Logger.getLogger(WekaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataSet;
    }
  
        
    public static ArrayList<Double> weka1() throws IOException, SQLException  {
        //File file = createCSV.createCSVFile();
        createCSV.createCSVFile();
        System.out.println("hey");
        ArrayList<Double> data = new ArrayList<Double>();
        try {
        
            LibSVM svm = new LibSVM();
            
            NaiveBayes nB = new NaiveBayes();
            
            data = train(nB, csv2arff());
        } catch (IOException ex) {
            Logger.getLogger(WekaData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WekaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    private static ArrayList<Double> train(Classifier c, Instances train) throws Exception {
        c.buildClassifier(train);
        Evaluation eval = new Evaluation(train);
        eval.crossValidateModel(c, train, 10, new Random(1));
//        System.out.println(eval.toClassDetailsString());
        result = eval.toClassDetailsString();
        ArrayList<Double> data = toData(result);
        return data;
//        for(double d:data)
//            System.out.println(d);
        
    }
    public static String getResult()
    {
        return result;
    }
    
    private static ArrayList<Double> toData(String s){
        ArrayList<Double> data = new ArrayList<>();

        s = s.substring(s.indexOf("0"));
        String [] temp = s.split(" ");
        for(int i=0;i<temp.length;i++){
            if(temp[i].startsWith("0")||temp[i].startsWith("1")) {
                data.add(Double.parseDouble(temp[i]));
            }  
        }
        return data;
    }
    
            
            
    public static void main(String[] args) throws Exception {
        weka1();
    }
    
}
