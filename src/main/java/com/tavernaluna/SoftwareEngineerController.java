package com.tavernaluna;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService, SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerService = softwareEngineerService;
        this.softwareEngineerRepository = softwareEngineerRepository;
    }


    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getSoftwareEngineerById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineer(id);
    }

    @GetMapping("/name/{name}")
    public SoftwareEngineer getSoftwareEngineerByName(@PathVariable String name) {
        return softwareEngineerService.getSoftwareEngineerByName(name);
    }

    @GetMapping("/techStack/{techStack}")
    public SoftwareEngineer getSoftwareEngineerByTechStack(@PathVariable String techStack) {
        return softwareEngineerService.getSoftwareEngineerByTechStack(techStack);
    }

    @PostMapping
    public void addSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteSoftwareEngineer(@PathVariable Integer id) {
        return softwareEngineerRepository.findById(id)
                .map(engineer -> {
                        softwareEngineerRepository.delete(engineer);
                        return ResponseEntity.ok("Engineer with ID " + id + " deleted successfully");
                        }
                )
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
