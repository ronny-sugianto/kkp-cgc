/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;

import core.client.SqlClient;
import core.models.Inventory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ronny
 */
public class InventoryService {

    private final static Connection CONNECTION = SqlClient.instance();
    private ResultSet result;

    public ArrayList<Inventory> getAll() {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT * FROM inventory");
            ArrayList arr = new ArrayList();

            while (result.next()) {
                Inventory inv = new Inventory(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("qty"),
                        result.getInt("price")
                );

                arr.add(inv);
            }
            if (!arr.isEmpty()) {
                return arr;
            }
        } catch (SQLException e) {
            System.out.println("[getAll] ERROR: " + e);
        }
        return null;
    }

    public ArrayList<Inventory> getByName(String name) {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT * FROM inventory where name like '%" + name + "%'");
            ArrayList arr = new ArrayList();

            while (result.next()) {
                Inventory inv = new Inventory(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("qty"),
                        result.getInt("price")
                );

                arr.add(inv);
            }
            if (!arr.isEmpty()) {
                return arr;
            }
        } catch (SQLException e) {
            System.out.println("[getByName] ERROR: " + e);
        }
        return null;
    }

    public Inventory getById(int id) {
        try {
            Statement query = CONNECTION.createStatement();
            result = query.executeQuery("SELECT * FROM inventory WHERE id =" + id);

            if (result.next()) {

                Inventory inv = new Inventory(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("qty"),
                        result.getInt("price")
                );
                return inv;
            }

        } catch (SQLException e) {
            System.out.println("[getById] ERROR: " + e);
        }
        return null;
    }

    public void insert(Inventory inventory) {
        try {
            Statement query = CONNECTION.createStatement();
            query.executeUpdate("INSERT INTO inventory(name,qty,price,timestamp) VALUES ('"
                    + inventory.getName() + "','"
                    + inventory.getQty() + "','"
                    + inventory.getPrice()
                    + "',NOW())"
            );

        } catch (SQLException e) {
            System.out.println("[insert] ERROR: " + e);
        }

    }

    public void update(Inventory inventory) {
        try {
            Statement query = CONNECTION.createStatement();
            query.executeUpdate("UPDATE inventory SET name = '"
                    + inventory.getName() + "', qty = '" + inventory.getQty()
                    + "', price = '" + inventory.getPrice()
                    + "', timestamp = now()"
                    + " where id =" + inventory.getId()
            );

        } catch (SQLException e) {
            System.out.println("[update] ERROR: " + e);
        }

    }

    public void delete(int id) {
        try {
            Statement query = CONNECTION.createStatement();
            query.executeUpdate("DELETE FROM inventory where id =" + id);

        } catch (SQLException e) {
            System.out.println("[delete] ERROR: " + e);
        }
    }

}
