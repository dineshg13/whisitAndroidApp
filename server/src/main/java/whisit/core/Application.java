package whisit.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by dinesh on 11/19/2015.
 */
@SpringBootApplication
@EnableMongoRepositories("whisit.repository")
@ComponentScan(value = {"whisit.controller", "whisit.model", "whisit.config", "whisit.component"})

public class Application {
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
}