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
import org.jfree.data.xy.IntervalXYDataset;
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
                    plot1.setDrawingSupplier(getSupplier());
                    plot1.setOutlinePaint(null);
                    plot1.setShadowPaint(null);
                    plot1.setLabelOutlinePaint(null);
                    plot1.setBackgroundPaint(null);
                    break;
                case "categoryx":
                    chart = ChartFactory.createBarChart(
                            chartTitle, " ", " ", 
                            (CategoryDataset)dataSet,
                            PlotOrientation.VERTICAL,
                            true,
                            true,
                            false);
                    CategoryPlot plot3 = (CategoryPlot) chart.getPlot();
                    plot3.setBackgroundAlpha(0.5f);
                    plot3.setDrawingSupplier(getSupplier());
                    BarRenderer customBarRenderer = (BarRenderer) plot3.getRenderer();
                    customBarRenderer.setBarPainter( new StandardBarPainter() );
                    customBarRenderer.setItemMargin(-0.01);
                    break;
                case "categoryy":
                    chart = ChartFactory.createBarChart(
                            chartTitle, "Post/Under", "Number", 
                            (CategoryDataset)dataSet,
                            PlotOrientation.HORIZONTAL,
                            true,
                            true,
                            false);
                    CategoryPlot plot5 = (CategoryPlot) chart.getPlot();
                    plot5.setBackgroundAlpha(0.5f);
                    plot5.setDrawingSupplier(getSupplier());
                    BarRenderer customBarRenderer2 = (BarRenderer) plot5.getRenderer();
                    customBarRenderer2.setBarPainter( new StandardBarPainter() );
                    customBarRenderer2.setItemMargin(-0.01);
                    break;
                case "line":
                    chart = ChartFactory.createLineChart(      
                            chartTitle, "Year","GPA Grade", // chart title
                           (CategoryDataset)dataSet,// data
                            PlotOrientation.VERTICAL,
                            true,           // include legend
                            true,
                            false);
                    CategoryPlot plot4 = (CategoryPlot) chart.getPlot();
                    plot4.setBackgroundAlpha(0.5f);
                    plot4.setDomainGridlinePaint(Color.white); 
                    plot4.setRangeGridlinePaint(Color.white);
                    plot4.setDrawingSupplier(getSupplier());
                    ValueAxis valueaxis = plot4.getRangeAxis();
                    valueaxis.setRange(3.2D, 3.5D);
                    valueaxis.setAutoRange(false);
                    //XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)plot2.getRenderer(); 
                    break;
            }
            chart.setBorderVisible(false);
            chart.setBackgroundPaint(null);
            
            panel = new ChartPanel(chart);   
            panel.setPreferredSize(new Dimension(400, 300));
            panel.setOpaque(false);
            return panel;
                    
    }
    public static DefaultDrawingSupplier getSupplier()
    {
        Paint[] color = new Paint[]{
                     new Color(59,189,211),
                     new Color(178,184,194),
                     new Color(135,206,250),
                     new Color(0,191,255),
                     ChartColor.LIGHT_BLUE,
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
        return a;
        
    }
}
