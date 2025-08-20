package org.lookice.service;

import org.lookice.model.Apprehension;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprehensionRepository extends JpaRepository<Apprehension, Integer> {
    // JpaRepository gives you: findAll, findById, save, deleteById, etc.

    @Query("SELECT DISTINCT a.apprehensionState FROM Apprehension a WHERE a.apprehensionState IS NOT NULL")
    List<String> findDistinctStates();

//    @Query(value = """
//        SELECT *
//        FROM ice_data.apprehensions
//        WHERE apprehension_state IS NOT NULL
//          AND apprehension_criminality IS NOT NULL
//          AND apprehension_state = :state
//        LIMIT 100
//        """, nativeQuery = true)
    @Query("""
    SELECT a 
    FROM Apprehension a
    WHERE a.apprehensionState IS NOT NULL
      AND a.apprehensionCriminality IS NOT NULL
      AND LOWER(a.apprehensionState) = LOWER(:state)
    """)
    List<Apprehension> findTop100ByState(@Param("state") String state, Pageable pageable);
}
