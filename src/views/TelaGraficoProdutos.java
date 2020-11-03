package views;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class TelaGraficoProdutos extends ApplicationFrame {

    public TelaGraficoProdutos(String applicationTitle , String chartTitle ) {
        super( applicationTitle );

        //cria e configura o gráfico de barras
        JFreeChart graficoDeBarras = ChartFactory.createBarChart(
                chartTitle,
                "",
                "Número de itens",
                criarDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        //cria e configura o painel de plotagem do gráfico de barras
        ChartPanel plotagem = new ChartPanel( graficoDeBarras );
        plotagem.setPreferredSize(new java.awt.Dimension( 810 , 500 ) );
        setContentPane( plotagem );
    }

    //método que cria o dataset
    private CategoryDataset criarDataset( ) {
        final String audiovisual = "ÁUDIO / TV";
        final String informatica = "INFORMÁTICA";
        final String games = "GAMES";

        final String primeiroTri = "1° Trimestre";
        final String segundoTri = "2° Trimestre";
        final String terceiroTri = "3° Trimestre";
        final String quartoTri = "4° Trimestre";
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        //adição de produtos da categoria 'tv/audio' ao gráfico
        dataset.addValue( 1 , audiovisual , primeiroTri );
        dataset.addValue( 3 , audiovisual , segundoTri );
        dataset.addValue( 2 , audiovisual , terceiroTri );
        dataset.addValue( 1 , audiovisual , quartoTri );

        //adição de produtos da cateforia 'informática' ao gráfico
        dataset.addValue( 8 , informatica , primeiroTri );
        dataset.addValue( 4 , informatica , segundoTri );
        dataset.addValue( 10 , informatica , terceiroTri );
        dataset.addValue( 2 , informatica , quartoTri );

        //adição de produtos da categoria 'games' ao gráfico
        dataset.addValue( 5 , games , primeiroTri );
        dataset.addValue( 3 , games , segundoTri );
        dataset.addValue( 4 , games , terceiroTri );
        dataset.addValue( 2 , games , quartoTri );

        return dataset;
    }

}

