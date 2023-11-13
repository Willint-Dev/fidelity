package com.fidelity.movil.manager_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OptionalManager {
    @Id
    @Column(name = "ID_MANAGER")
    private long id;

    @Column(name = "NAME_MANAGER")
    private String name;

    @Column(name = "TYPE_MANAGER")
    private String type;

    @Column(name = "EMAIL_MANAGER")
    private String email;

    @Column(name = "PHONE_MANAGER")
    private String phone;

    @Column(name = "PASSWORD_MANAGER")
    private String password;

    @Column(name = "CREATION_DATE")
    private Date creation_date;

    @Column(name = "UPDATE_DATE")
    private Date update_date;

    @Column(name = "ID_CLIENT")
    private long id_client;
}
