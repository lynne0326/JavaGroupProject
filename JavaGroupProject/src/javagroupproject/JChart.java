package javagroupproject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.sql.*;
import java.sql.SQLException;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.*;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;


/**
 * This class is to draw charts
 * @author mac
 */
public class JChart {
    /**
     * This method is to draw different charts according to different datasets and chart types 
     * @param dataSet receive the dataset from the query from the database
     * @param chartTitle name a chart title
     * @param chartType inform what kind of chart should be drawn
     * @return return a chart panel
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
        public static ChartPanel generateChart(Dataset dataSet, String chartTitle, String chartType) throws ClassNotFoundException, SQLException {
        
            JFreeChart chart = null;
            ChartPanel panel = null;
        /**
         * draw different chart according to required chart type
         */
            switch(chartType) {
                case "pie":
                    chart = ChartFactory.createPieChart(// draw pie chart   
                            chartTitle,  // chart title
                            (PieDataset)dataSet, // data
                            true,           
                            true,           
                            false);
                    PiePlot plot1 = (PiePlot) chart.getPlot();// create plot to set properties of the chart             
                    plot1.setDrawingSupplier(getSupplier());// call method getSupplier() to get coulor from a predefined coulour pool
                    plot1.setOutlinePaint(null);// no outline
                    plot1.setShadowPaint(null);// no shadow
                    plot1.setLabelOutlinePaint(null);//no label outline
                    plot1.setBackgroundPaint(null);// bakground opaque
                    break;
                case "categoryx":
                    chart = ChartFactory.createBarChart(// create bar chart for citizenship display
                            chartTitle, null, null, // chart title
                            (CategoryDataset)dataSet,// data
                            PlotOrientation.HORIZONTAL,// set the chart horizonally
                            true,
                            true,
                            false);
                    CategoryPlot plot3 = (CategoryPlot) chart.getPlot();
                    plot3.setBackgroundAlpha(0.5f);
                    plot3.setDrawingSupplier(getSupplier());// get predefined color
                    BarRenderer customBarRenderer = (BarRenderer) plot3.getRenderer();
                   customBarRenderer.setBarPainter( new StandardBarPainter() );
                   customBarRenderer.setItemMargin(-0.01);
                    break;
                case "categoryy":
                    chart = ChartFactory.createBarChart(//create a bar chart for course disolay
                            chartTitle,null,null,//chart title
                            (CategoryDataset)dataSet,//data
                            PlotOrientation.HORIZONTAL,// set the chart horizonally
                            true,
                            true,
                            false);
                    CategoryPlot plot5 = (CategoryPlot) chart.getPlot();
                    plot5.setBackgroundAlpha(0.5f);
                    plot5.setDrawingSupplier(getSupplier());// get predefined color
                    BarRenderer customBarRenderer2 = (BarRenderer) plot5.getRenderer();
                    customBarRenderer2.setBarPainter( new StandardBarPainter() );
                    customBarRenderer2.setItemMargin(-0.01);
                    break;
                case "line":
                    chart = ChartFactory.createLineChart(// draw a line chart of average GPA 
                            chartTitle, "Year","GPA Grade", // chart title
                           (CategoryDataset)dataSet,// data
                            PlotOrientation.VERTICAL,// set the chart vertically
                            true,          
                            true,
                            false);
                    CategoryPlot plot4 = (CategoryPlot) chart.getPlot();
                    plot4.setBackgroundAlpha(0.5f);
                    plot4.setDomainGridlinePaint(Color.white); // set bakground line as white
                    plot4.setRangeGridlinePaint(Color.white);
                    plot4.setDrawingSupplier(getSupplier());// get predefined color
                    ValueAxis valueaxis = plot4.getRangeAxis();
                    valueaxis.setRange(3.3D, 3.5D);// set GPA range from 3.3 to 3.5
                    valueaxis.setAutoRange(false);
                    break;
            }
            chart.setBorderVisible(false);// no border
            chart.setBackgroundPaint(null);// background opaque
            
            panel = new ChartPanel(chart);// turn the chart to the chartpanel  
            if(chartType.equals("categoryx") )
            panel.setPreferredSize(new Dimension(700, 300));// set course chart larger size for diaplaying complete course name
            else
            panel.setPreferredSize(new Dimension(400, 300));    
            panel.setOpaque(false);
            return panel;// return chartPanel
                    
    }
        /**
         * This method is to define some color for charts
         * @return  return drawing supplier
         */
    public static DefaultDrawingSupplier getSupplier()
    {
        Paint[] color = new Paint[]{
                     new Color(59,189,211),// color code
                     new Color(178,184,194),
                     new Color(135,206,250),
                     new Color(0,191,255),
                     ChartColor.LIGHT_BLUE,// color
                     ChartColor.DARK_GREEN,
                     Color.lightGray,
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
        return a;// return a drawing supplier
        
    }
}
