package za.org.phyllis.robertson.home.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import za.org.phyllis.robertson.home.config.ApplicationConfig;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class PhyllisRobertsonHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhyllisRobertsonHomeApplication.class, args);
    }

}
