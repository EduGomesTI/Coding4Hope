package views;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class TelaGraficoPatrocinios extends ApplicationFrame {

    public TelaGraficoPatrocinios(String applicationTitle , String chartTitle ) {
        super( applicationTitle );

        //cria e configura o gráfico de barras
        JFreeChart graficoDeBarras = ChartFactory.createBarChart(
                chartTitle,
                "",
                "Valor (R$)",
                criarDataset(),
                PlotOrientation.HORIZONTAL,
                true, true, false);


        //cria e configura o painel de plotagem do gráfico de barras
        ChartPanel plotagem = new ChartPanel( graficoDeBarras );
        plotagem.setPreferredSize(new java.awt.Dimension( 810 , 500 ) );
        setContentPane( plotagem );

    }


    //método que cria o dataset
    private CategoryDataset criarDataset(  ) {
        final String associados = "PATRON. ASSOCIADOS";
        final String sazonais = "PATRON. SAZONAIS";

        final String primeiraSem = "1ª Semana";
        final String segundaSem = "2ª Semana";
        final String terceiraSem = "3ª Semana";
        final String quartaSem = "4ª Semana";
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        //adição de patrocinadores 'associados' ao gráfico
        dataset.addValue( 5750.00, associados , primeiraSem );
        dataset.addValue( 9650.00 , associados , segundaSem );
        dataset.addValue( 4500.00 , associados , terceiraSem );
        dataset.addValue( 6400.00, associados , quartaSem );

        //adição de patrocinadores 'sazonais' ao gráfico
        dataset.addValue( 2458.00 , sazonais , primeiraSem );
        dataset.addValue( 5035.00 , sazonais , segundaSem );
        dataset.addValue( 8540.00 , sazonais , terceiraSem );
        dataset.addValue( 4310.00 , sazonais , quartaSem );

        return dataset;
    }

}

