package org.lookice.service;

import org.lookice.model.Apprehension;
import org.lookice.model.ApprehensionSummary;
import org.lookice.model.Detainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

// RENAME IceDataEntityService
@Service
public class ApprehensionService {

    @Autowired
    private DetainersRepository detainerRepository;

    @Autowired
    private ApprehensionRepository apprehensionRepository;

    public ApprehensionService() {
    }

    public List<String> getDistinctStates() {
        return apprehensionRepository.findDistinctStates();
    }

    public Map<String,Object> getByState(String state, PageRequest pageRequest) {
        List<Apprehension> byState = apprehensionRepository.findByState(state, pageRequest);
        long count = apprehensionRepository.countByApprehensionState(state);
        System.out.println(count);

        HashMap<String, Object> response = new HashMap<>();
        response.put("data", byState);
        response.put("count", count);
        return response;
    }

    public Map<String, Object> getDetainersByState(String state, PageRequest pageRequest) {
        List<Detainer> byState = detainerRepository.findByState(state, pageRequest);
        long count = detainerRepository.countByFacilityState(state);
        HashMap<String, Object> resultObject = new HashMap<>();
        resultObject.put("data", byState);
        resultObject.put("count", count);

        return resultObject;
    }

    public ApprehensionSummary getApprehensionSummary() {
        ApprehensionSummary apprehensionSummary = new ApprehensionSummary();

        long start = System.nanoTime();
        apprehensionSummary.apprehensionsByState = apprehensionRepository.stateCounts();
        long endStateCounts = System.nanoTime();
        apprehensionSummary.apprehensionsByGender = apprehensionRepository.apprehensionsCountedByGender();
        long endGenderCounts = System.nanoTime();
        apprehensionSummary.apprehensionsByCriminality = apprehensionRepository.apprehensionsByCriminality();
        long endCriminalityCounts = System.nanoTime();
        apprehensionSummary.apprehensionsByCitizenshipCountry = apprehensionRepository.apprehensionsByCitizenshipCountry();
        long endCitizenshipCounts = System.nanoTime();
        System.out.println("All summary queries: " + (endCitizenshipCounts - start)/10000000);
        return apprehensionSummary;
    }

    public List<Object[]> getArrestsByMonth() {
        return apprehensionRepository.apprehensionCountByMonth();
    }

//    private Map<String, Long> toMap(List<Object[]> results) {
//        return results.stream()
//                .map(val -> {
//                    // TODO: Need to preserve order here?
//                    System.out.println(val[0]);
//                    return val;
//                })
//                .collect(Collectors.toList()));
//(
//                        row -> (String) row[0],
//                        row -> (Long) row[1]
//                ));
//    }

}

