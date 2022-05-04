package za.org.phyllis.robertson.home.boundary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/rest")
public class HomeResource {

    @GetMapping("/")
    public String home() {
        return "<h1>Welcome Y'all</h1>";
    }

    @GetMapping("/home")
    public String user() {
        return "<h1>Welcome Homeys</h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1>Welcome Admin</h1>";
    }

    @GetMapping("/moderator")
    public String moderator() {
        return "<h1>Welcome Moderator</h1>";
    }
}
