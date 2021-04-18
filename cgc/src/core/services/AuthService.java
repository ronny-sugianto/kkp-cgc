/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;

import core.client.SqlClient;
import core.models.Users;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public String getRole(int userId) {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT name FROM role where id=" + userId);
            if (result.next()) {
                return result.getString("name");
            }
            return null;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }

    public ArrayList<Users> getAllUser() {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT users.id,full_name,email, role.name as role FROM users INNER JOIN role on role.id = users.role_id ORDER BY users.id ASC");
            ArrayList arr = new ArrayList();

            while (result.next()) {
                Users obj = new Users(
                        result.getInt("id"),
                        result.getString("full_name"),
                        result.getString("email"),
                        result.getString("role")
                );

                arr.add(obj);
            }
            if (!arr.isEmpty()) {
                return arr;
            }
            return null;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }

    public void close() {
        try {
            CONNECTION.close();
        } catch (SQLException e) {
            System.out.println("Fail To Close Connection");
        }
    }
}
