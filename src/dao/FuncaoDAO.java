package dao;

import dao.connections.OracleCon;
import entities.Funcao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncaoDAO {

 private Connection conexao;

    public void inserir(Funcao funcao){

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "INSERT INTO " +
                        "T_FUNCAO " +
                         "(ID_FUNCAO, DS_FUNCAO, BOL_CADASTRAR_USUARIO, BOL_CADASTRAR_DOACAO_PRODUTO, BOL_LIVRO_CAIXA, BOL_CADASTRAR_FUNCAO) " +
                         "VALUES " +
                         "(SQ_FUNCAO, ?, ?, ?, ?, ?"
            );

            comandoSQL.setString(1, funcao.getFuncao());
            comandoSQL.setString(2, funcao.getCadastrarUsuario());
            comandoSQL.setString(3, funcao.getCadastrarDoacaoProduto());
            comandoSQL.setString(4, funcao.getCadastrarLivroCaixa());
            comandoSQL.setString(5, funcao.getCadastrarFuncao());


            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void alterar(Funcao funcao){

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "UPDATE " +
                            "T_FUNCAO " +
                            "SET " +
                            "DS_FUNCAO=?" +
                            "BOL_CADASTRAR_USUARIO=?" +
                            "BOL_CADASTRAR_DOACAO_PRODUTO=?" +
                            "BOL_LIVRO_CAIXA=?" +
                            "BOL_CADASTAR_FUNCAO=?" +
                            "WHERE" +
                            "ID_FUNCAO=?"
            );

            comandoSQL.setString(1, funcao.getFuncao());
            comandoSQL.setString(2, funcao.getCadastrarUsuario());
            comandoSQL.setString(3, funcao.getCadastrarDoacaoProduto());
            comandoSQL.setString(4, funcao.getCadastrarLivroCaixa());
            comandoSQL.setString(5, funcao.getCadastrarFuncao());
            comandoSQL.setInt(6, funcao.getId());


            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void remover(Funcao funcao){

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement("DELETE FROM T_FUNCAO WHERE ID_FUNCAO=?");

            comandoSQL.setInt(1, funcao.getId());

            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void localizar(Funcao funcao){

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement("SELECT * FROM T_FUNCAO WHERE ID_FUNCAO=?");

            comandoSQL.setInt(1, funcao.getId());

            ResultSet resultado = comandoSQL.executeQuery();

            if(resultado.next()) {
                funcao.setId(resultado.getInt(1));
                funcao.setFuncao(resultado.getString(2));
                funcao.setCadastrarUsuario(resultado.getString(3));
                funcao.setCadastrarDoacaoProduto(resultado.getString(4));
                funcao.setCadastrarLivroCaixa(resultado.getString(5));
                funcao.setCadastrarFuncao(resultado.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Funcao> retornarTodos() {

        ArrayList<Funcao> funcoes = new ArrayList<Funcao>();

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try{

            comandoSQL = conexao.prepareStatement("SELECT * FROM T_FUNCAO");

            ResultSet resultados = comandoSQL.executeQuery();

            while(resultados.next()) {

                Funcao funcao = new Funcao();
                funcao.setId(resultados.getInt(1));
                funcao.setFuncao(resultados.getString(2));
                funcao.setCadastrarUsuario(resultados.getString(3));
                funcao.setCadastrarDoacaoProduto(resultados.getString(4));
                funcao.setCadastrarLivroCaixa(resultados.getString(5));
                funcao.setCadastrarFuncao(resultados.getString(6));

                funcoes.add(funcao);
            }

            conexao.close();
            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcoes;
    }



}
