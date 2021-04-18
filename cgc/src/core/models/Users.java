/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.models;

/**
 *
 * @author ronny
 */
public class Users {

    int id;
    String fullName;
    String email;
    String roleName;

    public Users(int id, String fullName, String email, String roleName) {
        this.id = id;
        this.fullName = fullName;
        this.roleName = roleName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getRoleName() {
        return roleName;
    }

}
