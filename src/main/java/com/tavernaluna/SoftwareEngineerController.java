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
    public ResponseEntity<?> getSoftwareEngineers() {
        try {
            return ResponseEntity.ok(softwareEngineerService.getAllSoftwareEngineers());
        }
        catch (NoSuchFieldException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getSoftwareEngineerById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(softwareEngineerService.getSoftwareEngineer(id));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getSoftwareEngineerByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(softwareEngineerService.getSoftwareEngineerByName(name));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("A Error Occurred");
        }

    }

    @GetMapping("/techStack/{techStack}")
    public ResponseEntity<?> getSoftwareEngineerByTechStack(@PathVariable String techStack) {
        try {
            return ResponseEntity.ok(softwareEngineerService.getSoftwareEngineerByTechStack(techStack));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        try {
            softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
            return new ResponseEntity<>(softwareEngineer, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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
