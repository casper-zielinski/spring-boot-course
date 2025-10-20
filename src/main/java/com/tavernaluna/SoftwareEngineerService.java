package com.tavernaluna;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(
            SoftwareEngineerRepository softwareEngineerRepository
    ) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineer(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "SoftwareEngineer with id " + id + " not found"
                ));
    }

    public SoftwareEngineer getSoftwareEngineerByName(String name) {
        return softwareEngineerRepository.findByNameContainingIgnoreCase(name).
                orElseThrow(() -> new IllegalStateException("SoftwareEngineer with name " + name + " not found"));
    }

    public SoftwareEngineer getSoftwareEngineerByTechStack(String techStack) {
            return softwareEngineerRepository.findByTechStack(Arrays.stream(techStack.split(",")).toList()).
                    orElseThrow(() ->
                            new IllegalStateException("SoftwareEngineer with techStack " + techStack + " not found"));
    }

}
