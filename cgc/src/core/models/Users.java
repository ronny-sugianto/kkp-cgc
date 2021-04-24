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

    final int id;
    final String fullName;
    final String email;
    final Roles roleEntity;
    final String password;

    public Users(int id, String fullName, String email, Roles roleEntity, String password) {
        this.id = id;
        this.fullName = fullName;
        this.roleEntity = roleEntity;
        this.email = email;
        this.password = password;
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

    public Roles getRoleEntity() {
        return roleEntity;
    }

    public String getPassword() {
        return password;
    }

}
