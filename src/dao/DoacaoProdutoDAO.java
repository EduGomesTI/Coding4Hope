package dao;

import dao.connections.MySQLCon;
import dao.connections.OracleCon;
import entities.DoacaoProduto;
import interfaces.IConnection;

import java.sql.*;
import java.util.ArrayList;

public class DoacaoProdutoDAO {

 private Connection conexao;

    public void inserir(DoacaoProduto produto){

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "INSERT INTO " +
                        "T_DOACAO_PRODUTO " +
                         "(ID_DOACAO_PRODUTO, DS_DOACAO_PRODUTO, VL_DOACAO_PRODUTO) " +
                         "VALUES " +
                         "(SQ_DOACAO_PRODUTO, ?, ?"
            );

            comandoSQL.setString(1, produto.getDescricaoDoacao());
            comandoSQL.setDouble(2, produto.getValorDoacao());


            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void alterar(DoacaoProduto produto){

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "UPDATE " +
                            "T_DOACAO_PRODUTO " +
                            "SET " +
                            "DS_DOACAO_PRODUTO=?" +
                            ", VL_DOACAO_PRODUTO=?" +
                            "WHERE" +
                            "ID_DOACAO_PRODUTO=?"

            );

            comandoSQL.setString(1, produto.getDescricaoDoacao());
            comandoSQL.setDouble(2, produto.getValorDoacao());
            comandoSQL.setInt(3, produto.getId());

            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void remover(DoacaoProduto produto){

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement("DELETE FROM T_LIVRO_CAIXA WHERE ID_LIVRO_CAIXA=?");

            comandoSQL.setInt(1, produto.getId());

            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void localizar(DoacaoProduto produto){

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_LIVRO_CAIXA WHERE ID_LIVRO_CAIXA=?");

            comandoSQL.setInt(1, produto.getId());

            ResultSet resultado = comandoSQL.executeQuery();

            if(resultado.next()) {
                produto.setId(resultado.getInt(1));
                produto.setDescricaoDoacao(resultado.getString(2));
                produto.setValorDoacao(resultado.getDouble(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<DoacaoProduto> retornarTodos() {

        ArrayList<DoacaoProduto> doacoes = new ArrayList<DoacaoProduto>();

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try{

            comandoSQL = conexao.prepareStatement("SELECT * FROM T_DOACAO_PRODUTO");

            ResultSet resultados = comandoSQL.executeQuery();

            while(resultados.next()) {

                DoacaoProduto doacaoProduto = new DoacaoProduto();
                doacaoProduto.setId(resultados.getInt(1));
                doacaoProduto.setDescricaoDoacao(resultados.getString(2));
                doacaoProduto.setValorDoacao(resultados.getDouble(3));

                doacoes.add(doacaoProduto);
            }

            conexao.close();
            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doacoes;
    }



}
