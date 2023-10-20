package com.fidelity.movil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id_user")
    private long id;

    @Column(name = "fullname")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "type")
    private String type;

    @Column(name = "billing")
    private float billing;

    @Column(name = "creation_date")
    private Date creation_date;

    @Column(name = "update_date")
    private Date update_date;


    public User() {
        super();
    }

    public User(long id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.type = "commercial";
        this.billing = 128.0F;
        this.creation_date = new Date();
        this.update_date = new Date();
    }
}
