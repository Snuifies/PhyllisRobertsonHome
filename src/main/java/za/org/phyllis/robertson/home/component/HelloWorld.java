package za.org.phyllis.robertson.home.component;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    private String firstName = "John";
    private String lastName = "Doe";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String showGreeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hello " + firstName + " " + lastName + "! Logged In User is " + authentication.getName();
    }
}
