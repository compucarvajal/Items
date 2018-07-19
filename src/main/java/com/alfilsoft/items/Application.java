/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author luis.carvajal
 */

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.alfilsoft"})
@EnableJpaRepositories("com.alfilsoft.*")
@EntityScan(basePackages = "com.alfilsoft.model")
public interface Application {
     public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    
}
