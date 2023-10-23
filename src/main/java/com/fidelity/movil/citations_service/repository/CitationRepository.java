package com.fidelity.movil.citations_service.repository;

import com.fidelity.movil.citations_service.model.Citation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CitationRepository extends JpaRepository<Citation, Long> {
    @Query(value = "SELECT * FROM citation  c WHERE c.id_manager = ?1", nativeQuery = true)
    public List<Citation> findByManager(long id);
}
