/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.models;

import java.util.Date;

/**
 *
 * @author ronny
 */
public class Transaction {

    final int id;
    final Date timestamp;
    final int totalAmount;
    final String fullName;

    public Transaction(int id, Date timestamp, int totalAmount, String fullName) {
        this.id = id;
        this.timestamp = timestamp;
        this.totalAmount = totalAmount;
        this.fullName = fullName;

    }

    public int getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getFullName() {
        return fullName;
    }

    public int getTotalAmount() {
        return totalAmount;

    }
}
