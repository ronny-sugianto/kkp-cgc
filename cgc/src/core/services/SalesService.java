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
public class SalesService {

    private final static Connection CONNECTION = SqlClient.instance();
    private ResultSet result;

    public int insert(int totalPayment) {
        try {
            Statement query = CONNECTION.createStatement();
            query.executeUpdate("INSERT INTO transaction(timestamp,total) VALUES (now()," + totalPayment + ")", Statement.RETURN_GENERATED_KEYS);

            result = query.getGeneratedKeys();

            if (result.next()) {
                return result.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("[insert] ERROR: " + e);
        }
        return 0;
    }

    public void insertItem(int transactionId, int inventoryId, int userId, int qty, int price) {

        try {
            Statement query = CONNECTION.createStatement();
            query.executeUpdate("INSERT INTO transaction_detail(transaction_id,inventory_id,user_id,qty,price) VALUES (" + transactionId + "," + inventoryId + ", " + userId + "," + qty + "," + price + ")");

        } catch (SQLException e) {
            System.out.println("[insertItem] ERROR: " + e);
        }
    }
}
