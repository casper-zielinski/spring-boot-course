package com.tavernaluna;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEnginnerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEnginnerService(
            SoftwareEngineerRepository softwareEngineerRepository
    ) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }
}
