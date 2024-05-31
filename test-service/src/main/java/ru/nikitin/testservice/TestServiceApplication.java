package ru.nikitin.testservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }
//
//    @Autowired
//    private LogService service;
//
//    @PostConstruct
//    public void printCurrentTime() {
//        service.toServ();
//    }
}
