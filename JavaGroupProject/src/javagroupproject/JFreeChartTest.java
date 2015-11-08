package javagroupproject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author lingyanjiang
 */
public class JFreeChartTest {
    public static ChartPanel generateChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "a", "Jan");
        dataset.addValue(200, "b", "Jan");
        dataset.addValue(300, "c", "Jan");
        dataset.addValue(400, "d", "Jan");
        JFreeChart chart = ChartFactory.createBarChart(
                "Chart", 
                "num",
                "type",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false);
        ChartPanel p = new ChartPanel(chart);
        return p;
    }
}
