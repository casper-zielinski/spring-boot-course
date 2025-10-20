package com.tavernaluna;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SoftwareEngineerRepository
        extends JpaRepository<SoftwareEngineer,Integer> {
    // Searches by Name
    Optional<SoftwareEngineer> findByNameContainingIgnoreCase(String name);
    // Searches by TeckStack
    Optional<SoftwareEngineer> findByTechStack(List<String> techStack);
}
