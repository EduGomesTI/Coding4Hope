package dao;

import dao.connections.MySQLCon;
import dao.connections.OracleCon;
import interfaces.IConnection;

import javax.swing.JOptionPane;
import java.sql.Connection;

public class test {

    public static void main(String[] args) {

        IConnection conn = new MySQLCon();

        Connection conexao = conn.con();

        if(conexao==null) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão");
        }else {
            JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso!");
        }
    }
}

