package org.lookice.service;

import org.lookice.model.Detainer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetainersRepository extends JpaRepository<Detainer, Integer> {

//    AND d.detainerPreparedCriminality IS NOT NULL
    @Query("""
    SELECT d
    FROM Detainer d
    WHERE d.facilityState IS NOT NULL
    AND LOWER(d.facilityState) = LOWER(:state)
    """)
    List<Detainer> findByState(@Param("state") String state, Pageable pageable);

    long countByFacilityState(String state);

}
