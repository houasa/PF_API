package com.prosperity.pas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Micro-PAS API host — the single front door. Embeds the Product Engine in-process
 * (Decision A1). Placed at the {@code com.prosperity.pas} root so component,
 * entity, and repository scanning cover every domain module package
 * ({@code policy}, {@code servicing}, {@code anniversary}, {@code newbusiness},
 * {@code productconfig}, {@code api}).
 */
@SpringBootApplication
public class PfApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfApiApplication.class, args);
    }
}
