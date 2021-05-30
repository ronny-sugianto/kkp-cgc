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

    public static void validate() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi gagal");
        }
    }

    public static Connection instance() {

        validate();

        try {
<<<<<<< HEAD
        //    String DB = "jdbc:mysql://192.168.64.2:3306/cgc";
            String DB = "jdbc:mysql://localhost/cgc";
            String user = "root";
            String pass = "";//"kuliahkerjapraktek";//"kuliahkerjapraktek";
=======
            String DB = "jdbc:mysql://192.168.64.2:3306/cgc";
//            String DB = "jdbc:mysql://localhost/cgc";
            String user = "root";
            String pass = "kuliahkerjapraktek";//"kuliahkerjapraktek";
>>>>>>> bfe0b3524a509f1e1b75fa4338e5c0ac6ed4a839
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

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
