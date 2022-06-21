package  za.co.phyllis.robertson.home.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author snuif
 */
@Configuration
public class WelcomePageRedirect implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/home");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

}
