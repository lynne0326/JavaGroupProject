/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagroupproject;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class WekaTest {
    //static DefaultDataSetFactory dls;
    //static ListDataSet dataSet;
            
    /**
    public static void jdmptest() throws FileNotFoundException  {
        try {
            dls = new DefaultDataSetFactory();
            
            dataSet = dls.importFromFile(FileFormat.CSV, new File("iris.csv"));
            NaiveBayesClassifier classifier = new NaiveBayesClassifier();
            if (dataSet != null && classifier != null) {
                
                classifier.trainAll(dataSet);
                
                // use the classifier to make predictions
                classifier.predictAll(dataSet);
                
                
                // get the results
                double accurary = dataSet.getAccuracy();
                
                System.out.println("accuracy: " + accurary);
            }
        } catch (IOException ex) {
            Logger.getLogger(WekaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    */

    static Instances dataSet;
    
    
    public static Instances csv2arff() {
        //Dbconnection.tempTable();
        
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
            Logger.getLogger(WekaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataSet;
    }
  
    
    /**
     * try {
            InstanceQuery query = new InstanceQuery();
            query.setDatabaseURL("jdbc:mysql://mydatabase.cwhndt08kykb.us-west-2.rds.amazonaws.com:3306/studentinfor");
            query.setUsername("lynne");
            query.setPassword("abcd1234");
            query.setQuery("select * from studentinfor.temp");
            dataSet = query.retrieveInstances();
            
            ArffSaver saver = new ArffSaver();
            saver.setInstances(dataSet);
            File file = new File("test.arff");
            file.createNewFile();
            saver.setFile(file);
            saver.writeBatch();
        } catch (Exception ex) {
            Logger.getLogger(WekaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     *   
    
    /**
     * try {
            InstanceQuery query = new InstanceQuery();
            query.setDatabaseURL("jdbc:mysql://mydatabase.cwhndt08kykb.us-west-2.rds.amazonaws.com:3306/studentinfor");
            query.setUsername("lynne");
            query.setPassword("abcd1234");
            query.setQuery("select * from studentinfor.temp");
            dataSet = query.retrieveInstances();
            
            ArffSaver saver = new ArffSaver();
            saver.setInstances(dataSet);
            File file = new File("test.arff");
            file.createNewFile();
            saver.setFile(file);
            saver.writeBatch();
        } catch (Exception ex) {
            Logger.getLogger(WekaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     * 
     */
    

        
    public static void weka1() throws IOException, SQLException  {
        //File file = createCSV.createCSVFile();
        createCSV.createCSVFile();
        System.out.println("hey");
        try {
            /**
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File ("temp10.csv"));
            Instances data = loader.getDataSet();
            data.setClassIndex(0);
            
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            File file = new File("test.arff");
            file.createNewFile();
            saver.setFile(file);
            saver.writeBatch();
            
            //BufferedReader test = new BufferedReader(new FileReader("test.arff"));
            //Instances train = new Instances(test);
            
            //uses the last attribute as class attribute
            /**if (train.classIndex() == -1)
             * train.setClassIndex((train.numAttributes() - 1));*/
            
            //test.close();
            
            
            LibSVM svm = new LibSVM();
            
            NaiveBayes nB = new NaiveBayes();
            //J48 dT = new J48();
            
            //train(svm, csv2arff());
            train(nB, csv2arff());
            // train(dT, train);    
        } catch (IOException ex) {
            Logger.getLogger(WekaTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WekaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void train(Classifier c, Instances train) throws Exception {
        c.buildClassifier(train);
        Evaluation eval = new Evaluation(train);
        eval.crossValidateModel(c, train, 10, new Random(1));
        /**System.out.println(eval.toSummaryString("\nResults\n=====\n", true));
        System.out.println(eval.fMeasure(1) + " " + eval.precision(1) + " " + eval.recall(1));*/
        System.out.println(eval.toClassDetailsString());
        String result = eval.toClassDetailsString();
        String[] name = new String[6];
        int[] medium = new int[6];
        int[] low = new int[6];
        int[] noPay = new int[6];
        int[] excellent = new int[6];
        int[] high = new int[6];
        //result = result.split(result);
        String[] temp = result.split(" ");
        
        
        
        
    }
    
            
            
    public static void main(String[] args) throws Exception {
        //csv2arff();
        weka1();
    }
    
}
