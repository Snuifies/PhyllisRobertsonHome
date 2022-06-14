
package za.org.phyllis.robertson.home.jsf.util;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author snuif
 */
@Component("authorizationUtils")
@ViewScoped
public class AuthorizationUtils implements Serializable{
    public boolean isUserInRole(String role) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(role));
        }
        return false;
    }
}