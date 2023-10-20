package com.fidelity.movil.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id_client")
    private long id;

    @Column(name = "name_client")
    private String name;

    @Column(name = "client_type")
    private String type;

    @Column(name = "billing_client")
    private float billing;

    @Column(name = "email_client")
    private String email;

    @Column(name = "phone_client")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "id_manager", nullable = false)
    private FidelityManager FidelityManager;

    public Client() {
        super();
    }

    public Client(long id, String name, String type, float billing, String email, String phone, com.fidelity.movil.model.FidelityManager fidelityManager) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.billing = billing;
        this.email = email;
        this.phone = phone;
        FidelityManager = fidelityManager;
    }
}