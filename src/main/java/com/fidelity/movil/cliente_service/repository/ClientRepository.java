package com.fidelity.movil.cliente_service.repository;

import com.fidelity.movil.cliente_service.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "SELECT * FROM client  c WHERE c.id_manager = ?1", nativeQuery = true)
    List<Client> findAllByManager(long id);

    /*  BUSCA LOS CLIENTES QUE NO TENGAN UN GESTOR ASIGNADO */
    @Query(value = "SELECT * FROM CLIENT C WHERE C.ID_MANAGER IS NULL", nativeQuery = true)
    List<Client> loadCLients();

}
