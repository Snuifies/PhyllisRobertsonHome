package spring.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.org.phyllis.robertson.home.config.ApplicationConfig;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/rest")
public class EndpointController {

    @Autowired
    private final ApplicationConfig config;

    @GetMapping(path = "/version")
    public @ResponseBody String getAppVersion() {
        return config.getVersion();
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h2>Welcome Admin!</h2>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h2>Welcome User!</h2>";
    }

    @GetMapping("/all")
    public String all() {
        return "<h2>Hello Everyone!</h2>";
    }
}
