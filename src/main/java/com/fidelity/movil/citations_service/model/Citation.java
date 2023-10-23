package com.fidelity.movil.citations_service.model;

import com.fidelity.movil.cliente_service.model.Client;
import com.fidelity.movil.manager_service.model.FidelityManager;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "citation")
public class Citation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_citation")
    private long id;

    @Column(name = "date_citation")
    private Date date_citation;

    @Column(name = "reason_citation")
    private String reason_citation;

    @Column(name = "status_citation")
    private String status_citation;

    @Column(name = "creation_date")
    private Date creation_date;

    @Column(name = "update_citation")
    private Date update_citation;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client id_client;

    @ManyToOne
    @JoinColumn(name = "id_manager")
    private FidelityManager id_manager;

    public Citation() {
        super();
    }

    public Citation(long id, Date date_citation, String reason_citation, String status_citation, Client id_client, FidelityManager id_manager) {
        this.id = id;
        this.date_citation = date_citation;
        this.reason_citation = reason_citation;
        this.status_citation = status_citation;
        this.creation_date = new Date();
        this.update_citation = new Date();
        this.id_client = id_client;
        this.id_manager = id_manager;
    }
}
