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

    /* HACE REFERENCIA A LA RELACION QUE EXISTE ENTRE CLIENTE Y GESTOR */
    @ManyToOne
    @JoinColumn(name = "id_manager" )
    private FidelityManager manager;

    public Client() {
        super();
    }

    /* DEBE ESTUDIAR QUE ES SOBRECARGA DE CONSTRUCTORES PARA ENTENDER ESTO */
    public Client(long id, String name, String type, float billing, String email, String phone, FidelityManager fidelityManager) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.billing = billing;
        this.email = email;
        this.phone = phone;
        manager = fidelityManager;
    }

    public Client(long id, String name, String type, float billing, String email, String phone) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.billing = billing;
        this.email = email;
        this.phone = phone;
    }
}
