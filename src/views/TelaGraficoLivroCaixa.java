package views;

import java.awt.Font;

import javax.swing.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.experimental.chart.plot.CombinedCategoryPlot;
import org.jfree.ui.ApplicationFrame;


public class TelaGraficoLivroCaixa extends ApplicationFrame {

    public TelaGraficoLivroCaixa(String titulo) {
        super(titulo);
        JPanel painelDoLivro = criarPainelDoLivro();
        painelDoLivro.setPreferredSize(new java.awt.Dimension(800, 500));
        setContentPane(painelDoLivro);
    }


    //cria e retorna a colecao de dados
    public static CategoryDataset criarDataset1() {
        DefaultCategoryDataset colecao = new DefaultCategoryDataset();
        String operacao1 = "Saídas";
        String operacao2 = "Entradas";
        String mes1 = "Jan";
        String mes2 = "Fev";
        String mes3 = "Mar";
        String mes4 = "Abr";
        String mes5 = "Maio";
        String mes6 = "Jun";
        String mes7 = "Jul";
        String mes8 = "Ago";
        String mes9 = "Set";
        String mes10 = "Out";
        String mes11 = "Nov";
        String mes12 = "Dez";

        //adiciona os valores de saída ao gráfico
        colecao.addValue(19361.23, operacao1, mes1);
        colecao.addValue(18762.00, operacao1, mes2);
        colecao.addValue(20182.50, operacao1, mes3);
        colecao.addValue(19192.20, operacao1, mes4);
        colecao.addValue(25990.80, operacao1, mes5);
        colecao.addValue(30209.70, operacao1, mes6);
        colecao.addValue(33000.25, operacao1, mes7);
        colecao.addValue(32300.88, operacao1, mes8);
        colecao.addValue(26602.10, operacao1, mes9);
        colecao.addValue(29383.76, operacao1, mes10);
        colecao.addValue(null, operacao1, mes11);
        colecao.addValue(null, operacao1, mes12);

        //adiciona os valores de entrada ao gráfico
        colecao.addValue(21982.20, operacao2, mes1);
        colecao.addValue(19573.30, operacao2, mes2);
        colecao.addValue(20400.60, operacao2, mes3);
        colecao.addValue(18768.73, operacao2, mes4);
        colecao.addValue(20560.56, operacao2, mes5);
        colecao.addValue(31000.85, operacao2, mes6);
        colecao.addValue(35000.40, operacao2, mes7);
        colecao.addValue(28000.71, operacao2, mes8);
        colecao.addValue(32000.56, operacao2, mes9);
        colecao.addValue(30737.45, operacao2, mes10);
        colecao.addValue(null, operacao2, mes11);
        colecao.addValue(null, operacao2, mes12);

        return colecao;
    }


    //cria e retorna o grafico
    private static JFreeChart criarGraficoDeLinhas() {

        CategoryDataset datasetLivro = criarDataset1();
        NumberAxis rangeAxis = new NumberAxis("Value");
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer renderizador = new LineAndShapeRenderer();
        renderizador.setBaseToolTipGenerator(
                new StandardCategoryToolTipGenerator());
        CategoryPlot subplot = new CategoryPlot(datasetLivro, null, rangeAxis,
                renderizador);
        subplot.setDomainGridlinesVisible(true);


        CategoryAxis domainAxis = new CategoryAxis("Meses");
        CombinedCategoryPlot plot = new CombinedCategoryPlot(
                domainAxis, new NumberAxis("Valores (R$)"));
        plot.add(subplot, 2);
        domainAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 14));


        return new JFreeChart(
                "Livro Caixa (2020)",
                new Font("Tahoma", Font.BOLD, 18), plot, true);

    }

    //cria e retorna o painel
    public static JPanel criarPainelDoLivro() {
        JFreeChart graficoDeLinhas = criarGraficoDeLinhas();
        return new ChartPanel(graficoDeLinhas);
    }



}

