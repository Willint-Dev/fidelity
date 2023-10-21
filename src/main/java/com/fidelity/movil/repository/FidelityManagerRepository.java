package com.fidelity.movil.repository;

import com.fidelity.movil.model.FidelityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FidelityManagerRepository extends JpaRepository<FidelityManager, Long> {

    @Query(value = "SELECT * FROM fidelity_manager  f WHERE f.type_manager = ?1", nativeQuery = true)
    List<FidelityManager> findAllManagerByType(String type_manager);

    /* BUSCA LOS MANAGERS QUE TENGAN EL MENOR NUMERO DE CLIENTES ASIGNADOS */
    @Query(value = "SELECT F.ID_MANAGER, F.NAME_MANAGER, F.TYPE_MANAGER, F.EMAIL_MANAGER, F.PHONE_MANAGER, F.CREATION_DATE, F.UPDATE_DATE, F.PASSWORD_MANAGER FROM FIDElITY_MANAGER F LEFT JOIN (SELECT ID_MANAGER, COUNT(*) AS NUMBER_OF_TIMES FROM CLIENT GROUP BY ID_MANAGER ) C ON F.ID_MANAGER = C.ID_MANAGER ORDER BY C.NUMBER_OF_TIMES", nativeQuery = true)
    List<FidelityManager> findAllManagersOrderByNumberOfClients();


}
