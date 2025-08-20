package org.lookice.controller;

import org.lookice.model.Apprehension;
import org.lookice.service.ApprehensionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprehensions")
public class ApprehensionController {

    private final ApprehensionService apprehensionService;

    public ApprehensionController(ApprehensionService apprehensionService) {
        this.apprehensionService = apprehensionService;
    }

    @GetMapping
    public List<Apprehension> getAll() {
        return apprehensionService.getAll();
    }

    @GetMapping("/lists/{type}")
    public List<String> getList(@PathVariable String type) {
        if ("state".equalsIgnoreCase(type)) {
            return apprehensionService.getDistinctStates();
        } else {
            return List.of(); // return empty list for unsupported types
        }
    }

    @GetMapping(value = "", params="state")
    public List<Apprehension> getByState(@RequestParam String state) {
        return apprehensionService.getByState(state);
    }

    @GetMapping("/{id}")
    public Apprehension getById(@PathVariable String id) {
        return apprehensionService.getById(id);
    }

}
