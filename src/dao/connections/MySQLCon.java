package dao.connections;

import interfaces.IConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLCon implements IConnection {


    @Override
    public Connection con() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fiap?useTimezone=true&serverTimezone=UTC","root","1234");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
