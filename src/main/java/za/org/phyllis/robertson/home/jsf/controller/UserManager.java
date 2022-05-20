package za.org.phyllis.robertson.home.jsf.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.org.phyllis.robertson.home.exception.ResourceNotFoundException;
import za.org.phyllis.robertson.home.model.UserDO;
import za.org.phyllis.robertson.home.service.UserService;

@Component
@RequestScoped
public class UserManager implements Serializable {

    @Autowired
    UserService userService;

    private static final long serialVersionUID = -9107952969237527819L;

    private static final Logger LOGGER
            = LoggerFactory.getLogger(UserManager.class);

    public static final String HOME_PAGE_REDIRECT
            = "secured/home.jsf";
    public static final String LOGOUT_PAGE_REDIRECT
            = "logout.xhtml?faces-redirect=true";

    private String userId;
    private String userPassword;

    private UserDO currentUser;

    public String login() {
        try {
            // lookup the user based on user name and user password
            currentUser = userService.findByUsernameAndPassword(userId, userPassword);
            LOGGER.info("login successful for '{}'", userId);
            return HOME_PAGE_REDIRECT;
        } catch (ResourceNotFoundException ex) {
            LOGGER.info("login failed for '{}'", userId);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Login failed",
                            "Invalid or unknown credentials."));
            return null;
        }
    }

    public String logout() {
        String identifier = userId;

        currentUser = 
        // invalidate the session
        LOGGER.debug("invalidating session for '{}'", identifier);
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();

        LOGGER.info("logout successful for '{}'", identifier);
        return HOME_PAGE_REDIRECT;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public String isLoggedInForwardHome() {
        if (isLoggedIn()) {
            return HOME_PAGE_REDIRECT;
        }

        return null;
    }

    private UserDO find(String userId, String password) {
        UserDO result = null;
        if ("john.doe".equalsIgnoreCase(userId)
                && "1234".equals(password)) {
            result = UserDO.builder().username(userId).build();
        }

        return result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UserDO getCurrentUser() {
        return currentUser;
    }

    // do not provide a setter for currentUser!
}
