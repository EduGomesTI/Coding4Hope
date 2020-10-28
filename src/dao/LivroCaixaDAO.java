package dao;

import dao.connections.MySQLCon;
import dao.connections.OracleCon;
import entities.LivroCaixa;
import entities.enuns.Operacao;
import interfaces.IConnection;

import java.sql.*;
import java.util.ArrayList;

public class LivroCaixaDAO {

 private Connection conexao;
 private Operacao operacao;

    public void inserir(LivroCaixa livroCaixa){

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "INSERT INTO" +
                    " T_LIVRO_CAIXA (" +
                            "ID_LIVRO_CAIXA" +
                            ", DT_OPERACAO" +
                            ", TP_OPERACAO" +
                            ", VL_OPERACAO" +
                            ", DS_OPERACAO) " +
                    "VALUES " +
                            "(" +
                            "SQ_LIVRO_CAIXA" +
                            ", TO_DATE(?, 'DD/MM/YYYY')" +
                            ", ?" +
                            ", ?" +
                            ", ?)"
            );

            comandoSQL.setDate(1, (Date) livroCaixa.getDataOperacao());
            comandoSQL.setString(2, livroCaixa.getOperacao());
            comandoSQL.setDouble(3, livroCaixa.getValor());
            comandoSQL.setString(4, livroCaixa.getDescricao());

            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void alterar(LivroCaixa livroCaixa){

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "UPDATE " +
                    "T_LIVRO_CAIXA " +
                    "SET " +
                    "DT_OPERACAO=TO_DATE(?, 'DD/MM/YYYY')" +
                    ", TP_OPERACAO=?" +
                    ", VL_OPERACAO=?" +
                    ", DS_OPERACAO=? " +
                    "WHERE " +
                    "ID_LIVRO_CAIXA=?");

            comandoSQL.setDate(1, (Date) livroCaixa.getDataOperacao());
            comandoSQL.setString(2, livroCaixa.getOperacao());
            comandoSQL.setDouble(3, livroCaixa.getValor());
            comandoSQL.setString(4, livroCaixa.getDescricao());

            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void remover(LivroCaixa livroCaixa){

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement("DELETE FROM T_LIVRO_CAIXA WHERE ID_LIVRO_CAIXA=?");

            comandoSQL.setInt(1, livroCaixa.getId());

            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void localizar(LivroCaixa livroCaixa){

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_LIVRO_CAIXA WHERE ID_LIVRO_CAIXA=?");

            comandoSQL.setInt(1, livroCaixa.getId());

            ResultSet resultado = comandoSQL.executeQuery();

            if(resultado.next()) {
                livroCaixa.setId(resultado.getInt(1));
                livroCaixa.setDataOperacao(resultado.getDate(2));
                livroCaixa.setOperacao(resultado.getString(3));
                livroCaixa.setValor(resultado.getDouble(4));
                livroCaixa.setDescricao(resultado.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<LivroCaixa> retornarTodos() {

        ArrayList<LivroCaixa> livroCaixas = new ArrayList<LivroCaixa>();

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try{

            comandoSQL = conexao.prepareStatement("SELECT * FROM T_LIVRO_CAIXA");

            ResultSet resultados = comandoSQL.executeQuery();

            while(resultados.next()) {

                LivroCaixa livroCaixa = new LivroCaixa();
                livroCaixa.setId(resultados.getInt(1));
                livroCaixa.setDataOperacao(resultados.getDate(2));
                livroCaixa.setOperacao(resultados.getString(3));
                livroCaixa.setDescricao(resultados.getString(4));
                livroCaixa.setValor(resultados.getDouble(5));


                livroCaixas.add(livroCaixa);
            }

            conexao.close();
            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livroCaixas;
    }



}
