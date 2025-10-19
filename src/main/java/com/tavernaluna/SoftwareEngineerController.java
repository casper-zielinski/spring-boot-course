package com.tavernaluna;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {


    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return List.of(
                new SoftwareEngineer(
                        1,
                        "James",
                        Collections.singletonList("js, node, react, tailwindcss")
                ),
                (
                        new SoftwareEngineer(
                                2,
                                "Maddie",
                                Collections.singletonList("js, java, react, bootstraps, springboot")
                        )
                        )
        );
    }

}
