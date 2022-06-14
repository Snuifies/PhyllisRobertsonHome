
package za.org.phyllis.robertson.home.jsf.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author snuif
 */
@Component("authorizationUtils")
public class AuthorizationUtils {
    public boolean isUserInRole(String role) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(role));
        }
        return false;
    }
}
