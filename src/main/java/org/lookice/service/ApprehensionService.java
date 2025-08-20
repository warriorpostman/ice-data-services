package org.lookice.service;

import org.lookice.model.Apprehension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApprehensionService {

    private final Map<Integer, Apprehension> apprehensions = new HashMap<>();

    @Autowired
    private ApprehensionRepository apprehensionRepository;

    public ApprehensionService() {
        // Seed with some sample data
//        apprehensions.put("1", new Apprehension("1", "John Doe", "New York", "In Custody"));
//        apprehensions.put("2", new Apprehension("2", "Jane Smith", "Los Angeles", "Pending"));
    }

    public List<Apprehension> getAll() {
        return new ArrayList<>(apprehensions.values());
    }

    public List<String> getDistinctStates() {
        return apprehensionRepository.findDistinctStates();
    }

    public Apprehension getById(String id) {
        return apprehensions.get(id);
    }

    public List<Apprehension> getByState(String state) {
        return apprehensionRepository.findTop100ByState(state, PageRequest.of(0,100));
    }

    public Apprehension add(Apprehension apprehension) {
        apprehensions.put(apprehension.getArrestId(), apprehension);
        return apprehension;
    }
}

