package za.org.phyllis.robertson.home.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home() {
        return "<h1>Welcome Y'all</h1>";
    }

    @GetMapping("/staff")
    public String staff() {
        return "<h1>Welcome Staff Member</h1>";
    }

    @GetMapping("/manager")
    public String manager() {
        return "<h1>Welcome Moderator</h1>";
    }
    @GetMapping("/admin")
    public String administator() {
        return "<h1>Welcome Administator</h1>";
    }

}
