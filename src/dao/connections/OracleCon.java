package dao.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleCon {

    public static Connection con() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm82686", "101276");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
