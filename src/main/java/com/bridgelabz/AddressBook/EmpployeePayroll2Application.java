package com.bridgelabz.AddressBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.bridgelabz.AddressBook.model")
@EnableJpaRepositories("com.bridgelabz.AddressBook.repository")
public class EmpployeePayroll2Application {
    public static void main(String[] args) {
        SpringApplication.run(EmpployeePayroll2Application.class, args);
    }
}
