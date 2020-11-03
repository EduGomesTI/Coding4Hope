package dao;

import dao.connections.OracleCon;

import javax.swing.JOptionPane;

public class test {

    public static void main(String[] args) {
        if(OracleCon.con()==null) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão");
        }else {
            JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso!");
        }
    }
}

