package com.escolago;

import com.escolago.storage.StorageProperties;
import com.escolago.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
@EnableConfigurationProperties(StorageProperties.class)
public class EscolagoApplication {
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(EscolagoApplication.class, args);
    }

}
