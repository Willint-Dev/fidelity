package com.fidelity.movil.repository;

import com.fidelity.movil.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "SELECT * FROM client  c WHERE c.id_manager = ?1", nativeQuery = true)
    List<Client> findAllByManager(long id);

}
