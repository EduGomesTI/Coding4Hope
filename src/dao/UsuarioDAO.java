/*Esta Classe tem por objetivo gravar no banco de dados as tabelas
* de Pessoas e de Usuaários, visto que no sistema Usário é uma subclasse de Pessoas*/

package dao;

import dao.connections.OracleCon;
import entities.Funcao;
import entities.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class UsuarioDAO {

 private Connection conexao;

    public void inserir(Usuario usuario){

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            //Tabela T_PESSOA
            comandoSQL = conexao.prepareStatement(
                    "INSERT INTO" +
                    " T_PESSOA (" +
                            "ID_PESSOA" +
                            ", DT_NASCIMENTO" +
                            ", NB_CPF" +
                            ", NM_PESSOA" +
                    "VALUES " +
                            "(SQ_PESSOA" +
                            ", TO_DATE(?, 'DD/MM/YY')" +
                            ", ?" +
                            ", ?)"
            );

            comandoSQL.setDate(1, (java.sql.Date) usuario.getDataNascimento());
            comandoSQL.setString(2, usuario.getCpf());
            comandoSQL.setString(3, usuario.getNome());

            comandoSQL.executeUpdate();

            //Retorna o ID da T_PESSOA;
            comandoSQL = conexao.prepareStatement(
                    "SELECT " +
                            "MAX(ID_PESSOA) " +
                        "FROM " +
                            "T_PESSOA"
            );

            ResultSet resultado = comandoSQL.executeQuery();

            //Guarda o ID
            int lastIdPessoa = resultado.getInt(1);
            //Retorna a data atual do sistema.
            Date ultimoLogin = new Date();

            //Tabela T_USUARIO
            comandoSQL = conexao.prepareStatement(
                    "INSERT INTO" +
                            " T_USUARIO (" +
                            "ID_USARIO" +
                            ", ID_PESSOA" +
                            ", DS_SENHA" +
                            ", DS_EMAIL" +
                            ", DT_ULTIMO_LOGIN" +
                            ", ID_FUNCAO" +
                         "VALUES " +
                         "(SQ_USUARIO" +
                         ", ?"+
                         ", ?"+
                         ", ?"+
                         ", ?"+
                         ", ?"
            );

            comandoSQL.setInt(1, lastIdPessoa);
            comandoSQL.setString(2, usuario.getSenha());
            comandoSQL.setString(3, usuario.getEmail());

            comandoSQL.setDate(4, (java.sql.Date) ultimoLogin);
            comandoSQL.setInt(5, usuario.getFuncao().getId());

            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void alterar(Usuario usuario){

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            //Tabela T_PESSOA
            comandoSQL = conexao.prepareStatement(
                    "UPDATE" +
                            " T_PESSOA " +
                            " SET" +
                            ", DT_NASCIMENTO =TO_DATE(?, 'DD/MM/YY')" +
                            ", NB_CPF =?" +
                            ", NM_PESSOA =?" +
                            " WHERE" +
                            "ID_PESSOA =?"
            );

            comandoSQL.setDate(1, (java.sql.Date) usuario.getDataNascimento());
            comandoSQL.setString(2, usuario.getCpf());
            comandoSQL.setString(3, usuario.getNome());
            comandoSQL.setInt(4, usuario.getIdPessoa());

            comandoSQL.executeUpdate();

            //Tabela T_USUARIO
            comandoSQL = conexao.prepareStatement(
                    "UPDATE" +
                            " T_USUARIO " +
                            "SET " +
                            ", ID_PESSOA =?" +
                            ", DS_SENHA =?" +
                            ", DS_EMAIL =?" +
                            ", ID_FUNCAO =?" +
                            " WHERE " +
                            " ID_USUARIO =?"
            );

            comandoSQL.setInt(1, usuario.getIdPessoa());
            comandoSQL.setString(2, usuario.getSenha());
            comandoSQL.setString(3, usuario.getEmail());
            comandoSQL.setInt(4, usuario.getFuncao().getId());
            comandoSQL.setInt(5, usuario.getId());

            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void remover(Usuario usuario){

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement("DELETE FROM T_PESSOA WHERE ID_PESSOA=?");

            comandoSQL.setInt(1, usuario.getIdPessoa());

            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void localizar(Usuario usuario) {

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "SELECT " +
                            " p.dt_nascimento" +
                            ", p.nb_cpf" +
                            ", p.nm_pessoa" +
                            ", u.ds_email" +
                            ", u.ds_senha" +
                            ", u.id_funcao" +
                            ", u.id_pessoa" +
                            ", u.id_usuario" +
                            " FROM" +
                            "T_PESSOA P" +
                            "INNER JOIN T_USUARIO U" +
                            "ON P.ID_PESSOA = U.ID_PESSOA" +
                            " WHERE U.ID_USUARIO = ?"
            );

            comandoSQL.setInt(1, usuario.getId());

            ResultSet resultado = comandoSQL.executeQuery();

            if (resultado.next()) {
                usuario.setDataNascimento(resultado.getDate(1));
                usuario.setCpf(resultado.getString(2));
                usuario.setNome(resultado.getString(3));
                usuario.setEmail(resultado.getString(4));
                usuario.setSenha(resultado.getString(5));
                Funcao funcao = new Funcao();
                funcao.setId(resultado.getInt(6));
                usuario.setFuncao(funcao);
                usuario.setIdPessoa(resultado.getInt(7));
                usuario.setId(resultado.getInt(8));
            }

            conexao.close();
            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Login
    public Usuario login(String email, String senha) {

        Usuario usuario = new Usuario();

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "SELECT"+
                    "p.dt_nascimento"+
                    ", p.nb_cpf"+
                    ", p.nm_pessoa"+
                    ", u.ds_email"+
                    ", u.ds_senha"+
                    ", u.id_funcao"+
                    ", u.id_pessoa"+
                    ", u.id_usuario"+
                    ", f.ds_funcao"+
                    ", f.bol_cadastrar_usuario"+
                    ", f.bol_cadastrar_doacao_produto"+
                    ", f.bol_livro_caixa"+
                    ", f.bol_cadastrar_funcao"+
                    " FROM"+
                    " T_PESSOA p"+
                    " INNER JOIN"+
                    " T_USUARIO u"+
                    " ON p.id_pessoa = u.id_pessoa"+
                    " INNER JOIN"+
                    " T_FUNCAO f"+
                    " ON u.id_funcao = f.id_funcao"+
                    " WHERE"+
                    " u.ds_email =?"+
                    " AND"+
                    " u.ds_senha =?"
            );

            comandoSQL.setString(1, email);
            comandoSQL.setString(2, senha);

            ResultSet resultado = comandoSQL.executeQuery();

            if (resultado.next()) {
                usuario.setDataNascimento(resultado.getDate(1));
                usuario.setCpf(resultado.getString(2));
                usuario.setNome(resultado.getString(3));
                usuario.setEmail(resultado.getString(4));
                usuario.setSenha(resultado.getString(5));
                //Dados da Tabela de funções do ssitema
                Funcao funcao = new Funcao();
                funcao.setId(resultado.getInt(6));
                funcao.setFuncao(resultado.getString(9));
                funcao.setCadastrarUsuario(resultado.getString(10));
                funcao.setCadastrarDoacaoProduto(resultado.getString(11));
                funcao.setCadastrarLivroCaixa(resultado.getString(12));
                funcao.setCadastrarFuncao(resultado.getString(13));
                //Fim dos dados da Tebale da funções do sistema
                usuario.setFuncao(funcao);
                usuario.setIdPessoa(resultado.getInt(7));
                usuario.setId(resultado.getInt(8));
            }

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario loginComCPF(String cpf, String email) {

        Usuario usuario = new Usuario();

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "SELECT "+
                            "p.dt_nascimento"+
                            ", p.nb_cpf"+
                            ", p.nm_pessoa"+
                            ", u.ds_email"+
                            ", u.ds_senha"+
                            ", u.id_funcao"+
                            ", u.id_pessoa"+
                            ", u.id_usuario"+
                            ", f.ds_funcao"+
                            ", f.bol_cadastrar_usuario"+
                            ", f.bol_cadastrar_doacao_produto"+
                            ", f.bol_livro_caixa"+
                            ", f.bol_cadastrar_funcao"+
                            " FROM"+
                            " T_PESSOA p"+
                            " INNER JOIN"+
                            " T_USUARIO u"+
                            " ON p.id_pessoa = u.id_pessoa"+
                            " INNER JOIN"+
                            " T_FUNCAO f"+
                            " ON u.id_funcao = f.id_funcao"+
                            " WHERE"+
                            " p.nb_cpf =?"+
                            " AND" +
                            " u.ds_email =?"
            );

            comandoSQL.setString(1, cpf);
            comandoSQL.setString(2, email);

            ResultSet resultado = comandoSQL.executeQuery();

            if (resultado.next()) {
                usuario.setDataNascimento(resultado.getDate(1));
                usuario.setCpf(resultado.getString(2));
                usuario.setNome(resultado.getString(3));
                usuario.setEmail(resultado.getString(4));
                usuario.setSenha(resultado.getString(5));
                //Dados da Tabela de funções do ssitema
                Funcao funcao = new Funcao();
                funcao.setId(resultado.getInt(6));
                funcao.setFuncao(resultado.getString(9));
                funcao.setCadastrarUsuario(resultado.getString(10));
                funcao.setCadastrarDoacaoProduto(resultado.getString(11));
                funcao.setCadastrarLivroCaixa(resultado.getString(12));
                funcao.setCadastrarFuncao(resultado.getString(13));
                //Fim dos dados da Tebale da funções do sistema
                usuario.setFuncao(funcao);
                usuario.setIdPessoa(resultado.getInt(7));
                usuario.setId(resultado.getInt(8));
            }

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void alterarSenha(Usuario usuario){

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "UPDATE t_usuario SET ds_senha =? WHERE ds_email =?"
            );

            comandoSQL.setString(2, usuario.getEmail());
            comandoSQL.setString(1, usuario.getSenha());

            comandoSQL.executeUpdate();

            conexao.close();

            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Usuario> retornarTodos() {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        conexao = OracleCon.con();

        PreparedStatement comandoSQL = null;

        try{

            comandoSQL = conexao.prepareStatement(
                    "SELECT " +
                            " p.dt_nascimento" +
                            ", p.nb_cpf" +
                            ", p.nm_pessoa" +
                            ", u.ds_email" +
                            ", u.ds_senha" +
                            ", u.id_funcao" +
                            ", u.id_pessoa" +
                            ", u.id_usuario" +
                            " FROM" +
                            "T_PESSOA P" +
                            "INNER JOIN T_USUARIO U" +
                            "ON P.ID_PESSOA = U.ID_PESSOA"
            );

            ResultSet resultados = comandoSQL.executeQuery();

            while(resultados.next()) {

                Usuario usuario = new Usuario();
                usuario.setDataNascimento(resultados.getDate(1));
                usuario.setCpf(resultados.getString(2));
                usuario.setNome(resultados.getString(3));
                usuario.setEmail(resultados.getString(4));
                usuario.setSenha(resultados.getString(5));
                Funcao funcao = new Funcao();
                funcao.setId(resultados.getInt(6));
                usuario.setFuncao(funcao);
                usuario.setIdPessoa(resultados.getInt(7));
                usuario.setId(resultados.getInt(8));

                usuarios.add(usuario);
            }

            conexao.close();
            comandoSQL.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }



}
