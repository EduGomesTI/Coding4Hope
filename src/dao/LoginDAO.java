package dao;

import dao.connections.MySQLCon;
import entities.Funcao;
import entities.Usuario;
import interfaces.IConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    //Login
    public Usuario login(String email, String senha) {

        Usuario usuario = new Usuario();

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "SELECT "+
                            " p.dt_nascimento "+
                            ", p.ds_cpf "+
                            ", p.nm_pessoa "+
                            ", u.ds_email "+
                            ", u.ds_senha " +
                            ", u.id_funcao "+
                            ", u.id_pessoa "+
                            ", u.id_usuario "+
                            ", f.ds_funcao "+
                            ", f.bol_cadastrar_usuario "+
                            ", f.bol_cadastrar_doacao_produto "+
                            ", f.bol_livro_caixa "+
                            ", f.bol_cadastrar_funcao "+
                            " FROM "+
                            " T_PESSOA p "+
                            " INNER JOIN "+
                            " T_USUARIO u "+
                            " ON p.id_pessoa = u.id_pessoa "+
                            " INNER JOIN "+
                            " T_FUNCAO f "+
                            " ON u.id_funcao = f.id_funcao "+
                            " WHERE "+
                            " u.ds_email =? "+
                            " AND "+
                            " u.ds_senha =? "
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

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        PreparedStatement comandoSQL = null;

        try {
            comandoSQL = conexao.prepareStatement(
                    "SELECT "+
                            "p.dt_nascimento"+
                            ", p.ds_cpf"+
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
                            " p.ds_cpf =?"+
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

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

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
}
