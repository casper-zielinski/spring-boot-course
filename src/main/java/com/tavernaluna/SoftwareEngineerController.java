package com.tavernaluna;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEnginnerService softwareEnginnerService;

    public SoftwareEngineerController(SoftwareEnginnerService softwareEnginnerService) {
        this.softwareEnginnerService = softwareEnginnerService;
    }


    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEnginnerService.getAllSoftwareEngineers();
    }

}
