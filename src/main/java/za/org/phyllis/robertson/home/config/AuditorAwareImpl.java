package za.org.phyllis.robertson.home.config;

import java.util.Optional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import za.org.phyllis.robertson.home.entity.security.User;

/**
 *
 * @author snuif
 */
@Configuration
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
//        }
//        return Optional.of(((User) authentication.getPrincipal()).getUsername());
    }
}
