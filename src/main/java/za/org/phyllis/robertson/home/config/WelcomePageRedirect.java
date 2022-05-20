package za.org.phyllis.robertson.home.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class automates configurations for the Web App
 *
 */
@Configuration
public class WelcomePageRedirect implements WebMvcConfigurer {

    /**
     * Provides default redirection
     * Example; if the user only enters http://localhost:8080 the user is by default redirected to http://localhost:8080/login.xhtml
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("forward:/login.xhtml");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
