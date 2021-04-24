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
public class Tickets {

    final int id;
    final Date timestamp;
    final String fullName;
    final String ticket;

    public Tickets(int id, Date timestamp, String fullName, String ticket) {
        this.id = id;
        this.timestamp = timestamp;
        this.fullName = fullName;
        this.ticket = ticket;
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

    public String getTicket() {
        return ticket;

    }
}
