package com.fidelity.movil.citations_service.repository;

import com.fidelity.movil.citations_service.model.Citation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CitationRepository extends JpaRepository<Citation, Long> {
    @Query(value = "SELECT * FROM citation  c WHERE c.id_manager = ?1", nativeQuery = true)
    public List<Citation> findByManager(long id);

    @Query(value = "INSERT INTO citation (id_citation, date_citation, reason_citation, status_citation, creation_date, update_citation,id_manager, id_client) VALUES(?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
    public Citation saveCitation(long id, Date date, String reason, String status, Date creation_date, Date update_date, long id_manager, long id_client);
}
