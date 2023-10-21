package com.fidelity.movil.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "fidelity_manager")
public class FidelityManager {

    @Id
    @Column(name = "id_manager")
    private long id;

    @Column(name = "name_manager")
    private String name;

    @Column(name = "type_manager")
    private String type;

    @Column(name = "email_manager")
    private String email;

    @Column(name = "phone_manager")
    private String phone;

    @Column(name = "password_manager")
    private String password;

    @Column(name = "creation_date")
    private Date creation_date;

    @Column(name = "update_date")
    private Date update_date;

    @OneToMany(mappedBy = "manager")
    private Set<Client> clients;

    public FidelityManager() {
        super();
    }

    public FidelityManager(long id, String name, String type, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.creation_date = new Date();
        this.update_date = new Date();
    }
}
