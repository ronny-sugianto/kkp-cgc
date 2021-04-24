/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;

import core.client.SqlClient;
import core.models.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

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

        } catch (SQLException e) {
            System.out.println("[signIn] ERROR: " + e);
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

        } catch (SQLException e) {
            System.out.println("[lostPassword] ERROR: " + e);
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
        } catch (SQLException e) {
            System.out.println("[getRole] ERROR: " + e);
        }
        return null;
    }

    public int getRoleIdByName(String name) {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT id FROM role where name='" + name + "'");
            if (result.next()) {
                return result.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("[getRoleIdByName] ERROR: " + e);
        }
        return 0;
    }

    public DefaultComboBoxModel getAllRole() {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT * FROM role");
            DefaultComboBoxModel dm = new DefaultComboBoxModel();
            while (result.next()) {

                dm.addElement(result.getString("name"));
            }
            return dm;
        } catch (SQLException e) {
            System.out.println("[getAllRole] ERROR : " + e);
        }
        return null;
    }

    public void insertUser(Users users) {
        try {
            Statement query = CONNECTION.createStatement();
            query.executeUpdate("INSERT INTO users(full_name,email,password,role_id) VALUES ('"
                    + users.getFullName() + "','" + users.getEmail()
                    + "','" + users.getPassword()
                    + "'," + users.getRoleEntity().getId() + ")"
            );

        } catch (SQLException e) {
            System.out.println("[updateUser] ERROR: " + e);
        }

    }

    public Users getUser(int id) {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT users.id,users.full_name,users.email,users.password,users.role_id, role.name as 'role_name' FROM users INNER JOIN role on role.id = role_id WHERE users.id =" + id);

            if (result.next()) {
                Roles roleEntity = new Roles(
                        result.getInt("role_id"),
                        result.getString("role_name")
                );

                Users obj = new Users(result.getInt("id"),
                        result.getString("full_name"),
                        result.getString("email"),
                        roleEntity,
                        result.getString("password")
                );
                return obj;
            }

        } catch (SQLException e) {
            System.out.println("[getUser] ERROR: " + e);
        }
        return null;
    }

    public ArrayList<Users> getAllUser() {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT users.id,full_name,email, role_id,role.name as 'role_name' FROM users INNER JOIN role on role.id = users.role_id ORDER BY users.id ASC");
            ArrayList arr = new ArrayList();

            while (result.next()) {
                Roles roleEntity = new Roles(
                        result.getInt("role_id"),
                        result.getString("role_name")
                );

                Users obj = new Users(
                        result.getInt("id"),
                        result.getString("full_name"),
                        result.getString("email"),
                        roleEntity,
                        null
                );

                arr.add(obj);
            }
            if (!arr.isEmpty()) {
                return arr;
            }
        } catch (SQLException e) {
            System.out.println("[getAllUser] ERROR: " + e);
        }
        return null;
    }

    public void updateUser(Users users) {
        try {
            Statement query = CONNECTION.createStatement();
            query.executeUpdate("UPDATE users SET full_name = '"
                    + users.getFullName() + "', email = '" + users.getEmail()
                    + "', password = '" + users.getPassword()
                    + "', role_id = " + users.getRoleEntity().getId()
                    + " where id =" + users.getId()
            );

        } catch (SQLException e) {
            System.out.println("[updateUser] ERROR: " + e);
        }

    }

    public void deleteUser(int id) {
        try {
            Statement query = CONNECTION.createStatement();
            query.executeUpdate("DELETE FROM users where id =" + id);

        } catch (SQLException e) {
            System.out.println("[deleteUser] ERROR: " + e);
        }
    }

    public void close() {
        try {
            CONNECTION.close();
        } catch (SQLException e) {
            System.out.println("Fail To Close Connection");
        }
    }
}
