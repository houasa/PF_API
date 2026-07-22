package com.prosperity.pas.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Micro-PAS API host — the single front door. Embeds the Product Engine in-process (Decision A1). */
@SpringBootApplication
public class PfApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfApiApplication.class, args);
    }
}
