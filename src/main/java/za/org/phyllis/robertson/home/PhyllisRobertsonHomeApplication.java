package za.org.phyllis.robertson.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import za.org.phyllis.robertson.home.config.Config;


@SpringBootApplication
@EnableConfigurationProperties(Config.class)
public class PhyllisRobertsonHomeApplication {


    public static void main(String[] args) {
        SpringApplication.run(PhyllisRobertsonHomeApplication.class, args);
    }
}
