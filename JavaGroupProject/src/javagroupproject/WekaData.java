package javagroupproject;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

/**
 *
 * @author Shuang
 */
public class WekaData {
    private static String result;
    
    public static Instances createInstances(File file) {
        Instances dataSet = null;
        try {
            CSVLoader loader = new CSVLoader();
            loader.setSource(file);
            dataSet = loader.getDataSet();
        } catch (Exception ex) {
            Logger.getLogger(WekaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataSet;
    }
  
    public static ArrayList<Double> classify() {
        ArrayList<Double> data = null;
        try {
            createCSV.createCSVFile();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(WekaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            NaiveBayes nB = new NaiveBayes();
            Instances ins = createInstances(new File("temp10.csv"));
            ins.setClassIndex(0);
            nB.buildClassifier(ins);
            //evaluation
            Evaluation eval = new Evaluation(ins);
            eval.crossValidateModel(nB, ins, 10, new Random(1));
            result = eval.toClassDetailsString();
            data = toData(result);
            
        } catch (Exception ex) {
            Logger.getLogger(WekaData.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return data;
    }
    
    public static ArrayList<Double> cluster(String str) {
        ArrayList<Double> dataset = null;
        try {
            createCSV.createCSVFile();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(WekaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Instances data = createInstances(new File("temp11.csv"));
            if (str.equals("salary")) {
                data.deleteAttributeAt(1);
            }
            else if (str.equals("GPA")){
                data.deleteAttributeAt(0);
            }
            else {
                System.out.println("cannot cluster");
                System.exit(0);
            }
            
            SimpleKMeans model = new SimpleKMeans();//simple em
            model.setNumClusters(2);//number of clusters
            model.buildClusterer(data);
            dataset = toDataCluster(model.toString());
            

            //evaluation
            ClusterEvaluation clsEval = new ClusterEvaluation();
            clsEval.setClusterer(model);
            clsEval.evaluateClusterer(data);
            

            
            return dataset;
            
            
        } catch (IOException ex) {
            Logger.getLogger(WekaData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WekaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataset;
    }
    
    private static ArrayList<Double> toData(String s) {
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
    
    private static ArrayList<Double> toDataCluster(String s) {
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
        return data;
    }

    /**
     * @return the result
     */
    public static String [] getResult() {
        if(result!=null){
            String [] resultSplited = result.split("\n");
            return resultSplited;
        }
        return null;
    }

    /**
     * @param aResult the result to set
     */
    public static void setResult(String aResult) {
        result = aResult;
    }
    
}
