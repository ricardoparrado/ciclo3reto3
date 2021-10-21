package com.usa.ciclo3.ciclo3.model;

import javax.persistence.*;

@Entity
@Table(name = "adminuser")
public class UAdministrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idadminuser;
    private String name;
    private String email;
    private String password;

    public UAdministrator() {

    }

    public UAdministrator(int idadminuser, String name, String email, String password) {
        super();
        this.idadminuser = idadminuser;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getIdadminuser() {
        return idadminuser;
    }

    public void setIdadminuser(Integer idadminuser) {
        this.idadminuser = idadminuser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
