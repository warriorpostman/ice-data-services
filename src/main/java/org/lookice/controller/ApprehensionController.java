package org.lookice.controller;

import org.lookice.model.Apprehension;
import org.lookice.model.ApprehensionSummary;
import org.lookice.model.Detainer;
import org.lookice.service.ApprehensionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/apprehensions", params="state")
    public List<Apprehension> getByState(@RequestParam String state, @RequestParam int start, @RequestParam int end) {
        System.out.println("start=" + start);
        return apprehensionService.getByState(state, PageRequest.of(start, end));
    }

    @GetMapping(value = "/apprehensions/summary")
    public ApprehensionSummary getSummary() {
        return apprehensionService.getApprehensionSummary();
    }

    @GetMapping(value = "/detainers", params="state")
    public List<Detainer> getByDetainersState(@RequestParam String state, @RequestParam int start, @RequestParam int end) {
        System.out.println("start=" + start);
        List<Detainer> detainersByState = apprehensionService.getDetainersByState(state, PageRequest.of(start, end));
//        System.out.println(detainersByState.get(0).getDetainerId());
//        System.out.println(detainersByState.get(1).getDetainerId());
//        System.out.println(detainersByState.get(2).getDetainerId());
        return detainersByState;
    }

//    @GetMapping("/{id}")
//    public Apprehension getById(@PathVariable String id) {
//        return apprehensionService.getById(id);
//    }

}
