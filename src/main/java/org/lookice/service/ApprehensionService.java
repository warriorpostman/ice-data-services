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

    public List<Apprehension> getByState(String state, PageRequest pageRequest) {
        List<Apprehension> byState = apprehensionRepository.findByState(state, pageRequest);
        return byState;
    }

    public List<Detainer> getDetainersByState(String state, PageRequest pageRequest) {
        List<Detainer> byState = detainerRepository.findByState(state, pageRequest);
        return byState;
    }

    public ApprehensionSummary getApprehensionSummary() {
        ApprehensionSummary apprehensionSummary = new ApprehensionSummary();
        apprehensionSummary.apprehensionsByState = apprehensionRepository.stateCounts();
        apprehensionSummary.apprehensionsByGender = apprehensionRepository.apprehensionsCountedByGender();
        apprehensionSummary.apprehensionsByCriminality = apprehensionRepository.apprehensionsByCriminality();
        apprehensionSummary.apprehensionsByCitizenshipCountry = apprehensionRepository.apprehensionsByCitizenshipCountry();
        return apprehensionSummary;
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

