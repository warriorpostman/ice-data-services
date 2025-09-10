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

    @Query("""
    SELECT a 
    FROM Apprehension a
    WHERE a.apprehensionState IS NOT NULL
      AND a.apprehensionCriminality IS NOT NULL
      AND LOWER(a.apprehensionState) = LOWER(:state)
    """)
    List<Apprehension> findByState(@Param("state") String state, Pageable pageable);

    long countByApprehensionState(String state);

//    @Query(value = """
//            select
//              apprehension_state,
//              COUNT(apprehension_state)
//            from apprehensions
//            group by
//              apprehension_state
//            order by
//              COUNT(apprehension_state) DESC;
//            """, nativeQuery = true)
    @Query("""
    SELECT a.apprehensionState, 
    COUNT(a.apprehensionState) FROM Apprehension a 
    WHERE a.apprehensionState is NOT NULL 
    GROUP BY a.apprehensionState
    ORDER BY COUNT(a) desc
    """)
    List<Object[]> stateCounts();

    @Query("""
    SELECT a.gender, 
    COUNT(a.gender) FROM Apprehension a 
    WHERE a.gender is NOT NULL 
    GROUP BY a.gender
    ORDER BY COUNT(a) desc
    """)
    List<Object[]> apprehensionsCountedByGender();

    @Query("""
    SELECT a.apprehensionCriminality,
    COUNT(a.apprehensionCriminality) 
    FROM Apprehension a 
    WHERE a.apprehensionCriminality is NOT NULL 
    GROUP BY a.apprehensionCriminality
    ORDER BY COUNT(a) desc
    """)
    List<Object[]> apprehensionsByCriminality();

    @Query("""
    SELECT a.citizenshipCountry,
    COUNT(a.citizenshipCountry) 
    FROM Apprehension a 
    WHERE a.citizenshipCountry is NOT NULL 
    GROUP BY a.citizenshipCountry
    ORDER BY COUNT(a) desc
    """)
    List<Object[]> apprehensionsByCitizenshipCountry();

    @Query(value = """
    SELECT
        TO_CHAR(apprehension_date, 'YYYY-MM') AS year_month,
        COUNT(*) AS apprehension_count
    FROM ice_data.apprehensions
    WHERE apprehension_date IS NOT NULL
    GROUP BY TO_CHAR(apprehension_date, 'YYYY-MM')
    ORDER BY year_month
    """,
    nativeQuery = true)
    List<Object[]> apprehensionCountByMonth();
}
