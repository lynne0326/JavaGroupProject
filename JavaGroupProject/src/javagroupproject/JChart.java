/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagroupproject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.sql.SQLException;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.*;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author mac
 */
public class JChart {
    
        public static ChartPanel generateChart(Dataset dataSet, String chartTitle, String chartType) throws ClassNotFoundException, SQLException {
        
            JFreeChart chart = null;
            ChartPanel panel = null;
        
            switch(chartType) {
                case "pie":
                    chart = ChartFactory.createPieChart(      
                            chartTitle,  // chart title
                            (PieDataset)dataSet, // data
                            true,           // include legend
                            true,           
                            false);
                    PiePlot plot1 = (PiePlot) chart.getPlot();
                    plot1.setBackgroundAlpha(0f);                 
                    plot1.setDrawingSupplier(getSupplier());
                    break;
                case "xy":
                    chart = ChartFactory.createXYLineChart(      
                            chartTitle, "x","y", // chart title
                           (XYDataset)dataSet,// data
                            PlotOrientation.VERTICAL,
                            true,           // include legend
                            true,
                            false);
                    XYPlot plot2 = (XYPlot) chart.getPlot();
                    plot2.setBackgroundAlpha(0.5f);
                    plot2.setDomainGridlinePaint(Color.white); 
                    plot2.setRangeGridlinePaint(Color.white);
                    plot2.setDrawingSupplier(getSupplier()); 
                    //XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)plot2.getRenderer(); 
                    break;
                case "category":
                    chart = ChartFactory.createBarChart(
                            chartTitle, "x", "y", 
                            (CategoryDataset)dataSet,
                            PlotOrientation.HORIZONTAL,
                            true,
                            true,
                            false);
                    CategoryPlot plot3 = (CategoryPlot) chart.getPlot();
                    plot3.setBackgroundAlpha(0.5f);
                    plot3.setDrawingSupplier(getSupplier());
                    break;
            }
            panel = new ChartPanel(chart);   
            panel.setPreferredSize(new Dimension(400, 200));
            panel.setBackground(Color.lightGray);
            return panel;
                    
    }
    public static DefaultDrawingSupplier getSupplier()
    {
        Paint[] color = new Paint[]{
                     Color.lightGray,
                     ChartColor.LIGHT_BLUE,
                     Color.green,
                     Color.red,
                     Color.orange,
                     Color.magenta,
                     Color.cyan,
                     Color.pink,
                     Color.gray,
                     Color.yellow,
                     ChartColor.DARK_RED,
                     ChartColor.DARK_GREEN,
                     ChartColor.LIGHT_RED,
                     ChartColor.DARK_YELLOW,
                     ChartColor.DARK_MAGENTA,
                     ChartColor.DARK_CYAN,
                     Color.lightGray,
                     ChartColor.LIGHT_RED,
                     ChartColor.LIGHT_BLUE,
                     ChartColor.LIGHT_GREEN,
                     ChartColor.LIGHT_YELLOW,
                     ChartColor.LIGHT_MAGENTA,
                     ChartColor.LIGHT_CYAN};
        DefaultDrawingSupplier a = new DefaultDrawingSupplier(color,DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
                             DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
                             DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
                             DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
        return a;
        
    }
}
