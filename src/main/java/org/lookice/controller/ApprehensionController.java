package org.lookice.controller;

import org.lookice.model.Apprehension;
import org.lookice.model.ApprehensionSummary;
import org.lookice.model.Detainer;
import org.lookice.service.ApprehensionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApprehensionController {

    private final ApprehensionService apprehensionService;

    public ApprehensionController(ApprehensionService apprehensionService) {
        this.apprehensionService = apprehensionService;
    }

    @GetMapping("/apprehensions/lists/{type}")
    public List<String> getList(@PathVariable String type) {
        if ("state".equalsIgnoreCase(type)) {
            return apprehensionService.getDistinctStates();
        } else {
            return List.of(); // return empty list for unsupported types
        }
    }

    @GetMapping("/apprehensions/month")
    public List<Object[]> getArrestsByMonth() {
        return apprehensionService.getArrestsByMonth();
    }

    @GetMapping(value = "/apprehensions", params="state")
    public Map<String,Object> getByState(@RequestParam String state, @RequestParam int pageNumber) {
        int PAGE_SIZE = 10;
        long start = System.nanoTime();
        Map<String, Object> response = apprehensionService.getByState(
                state,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by("apprehensionDate").ascending().and(Sort.by("arrestId").ascending()))
        );
        long end = System.nanoTime();
        System.out.println( "time retrieve apprehensions: " + ((end - start)/1000000));
        return response;
    }

    @GetMapping(value = "/apprehensions/summary")
    public ApprehensionSummary getSummary() {
        return apprehensionService.getApprehensionSummary();
    }

    @GetMapping(value = "/detainers", params="state")
    public Map<String,Object> getByDetainersState(@RequestParam String state, @RequestParam int pageNumber) {
        int PAGE_SIZE = 10;
        long start = System.nanoTime();
        Map<String, Object> response = apprehensionService.getDetainersByState(state,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by("detainerPrepareDate").ascending().and(Sort.by("detainerId").ascending()))
        );
        long end = System.nanoTime();
        System.out.println( "time retrieve detainers: " + ((end - start)/1000000));
        return response;
    }

//    @GetMapping("/{id}")
//    public Apprehension getById(@PathVariable String id) {
//        return apprehensionService.getById(id);
//    }

}
