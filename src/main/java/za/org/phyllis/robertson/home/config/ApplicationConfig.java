package za.org.phyllis.robertson.home.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "app")
public class ApplicationConfig {
    private String title;
    private String version;
    private String environment;
    private String primefacesTheme;


}
