/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronny
 */
public class SqlClient {

    private static Connection conn;

    public static Connection instance() {
        try {
            String DB = "jdbc:mysql://192.168.64.2:3306/cgc";
            String user = "root";
            String pass = "kuliahkerjapraktek";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = (Connection) DriverManager.getConnection(DB, user, pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return conn;
    }
}
