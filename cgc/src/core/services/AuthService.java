/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;

import core.client.SqlClient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ronny
 */
public class AuthService {

    private final static Connection CONNECTION = SqlClient.instance();
    private ResultSet result;

    public ResultSet signIn(String email, String password) {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT * FROM users where email='" + email + "' AND password='" + password + "'");

            if (result.next()) {
                return result;
            }

            return null;

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }

        return null;
    }

    public ResultSet lostPassword(String email) {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT id FROM users WHERE email = '" + email + "'"
            );

            if (result.next()) {
                int id = result.getInt("id");
                query.executeUpdate("INSERT INTO tickets(role_id,user_id,ticket,isDone) VALUES (1," + id + ",'Reset Password',0)");
                return result;
            }

            return null;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }
}
