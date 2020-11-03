package views;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;


public class TelaGraficoPatrocinadores extends ApplicationFrame {

    public TelaGraficoPatrocinadores(String applicationTitle , String chartTitle ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Meses",
                "Número de patrocinadores",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel plotPatrocinadores = new ChartPanel( lineChart );
        plotPatrocinadores.setPreferredSize( new Dimension( 810 , 500 ) );
        setContentPane( plotPatrocinadores );

    }

    private DefaultCategoryDataset createDataset( ) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        dataset.addValue( 94 , "patrocinadores" , "Jan" );
        dataset.addValue( 68 , "patrocinadores" , "Fev" );
        dataset.addValue( 75 , "patrocinadores" , "Mar" );
        dataset.addValue( 60 , "patrocinadores" , "Abr" );
        dataset.addValue( 45 , "patrocinadores" , "Maio" );
        dataset.addValue( 45 , "patrocinadores" , "Jun" );
        dataset.addValue( 35 , "patrocinadores" , "Jul" );
        dataset.addValue( 48 , "patrocinadores" , "Ago" );
        dataset.addValue( 50 , "patrocinadores" , "Set" );
        dataset.addValue( 34 , "patrocinadores" , "Out" );
        //dataset.addValue( 0 , "patrocinadores" , "Nov" );
        //dataset.addValue( 0 , "patrocinadores" , "Dez" );

        return dataset;
    }

}
