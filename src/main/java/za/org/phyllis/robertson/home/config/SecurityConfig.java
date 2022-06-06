package za.org.phyllis.robertson.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author snuif
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * To prevent the circular-reference problem create the PasswordEncoder
     * static and Inject into class
     *
     * @return
     */
    @Bean(name = "passwordEncoder")
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Add HttpSecurity SecurityFilterChain for Login and User access
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests(authorizeRequests
            -> authorizeRequests
                .antMatchers("/javax.faces.resource/**").permitAll()
                .anyRequest().authenticated()
        )
            .formLogin(formLogin
                -> formLogin
                .loginPage("/login.jsf").permitAll()
                .failureUrl("/login.jsf?error=true")
                .permitAll()
            )
            .logout().logoutSuccessUrl("/login.jsf")
            //            .authenticationManager(new CustomAuthenticationManager());
            .deleteCookies("JSESSIONID");
        return http.build();
    }

    /**
     * Create an InMemoryUserDetailsManager
     *
     * @return
     */
    @Bean
    @DependsOn({"passwordEncoder"})
    public InMemoryUserDetailsManager userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.builder().username("user").password(passwordEncoder.encode("pass")).roles("USER").authorities("ROLE_USER").build());
        manager.createUser(User.builder().username("admin").password(passwordEncoder.encode("pass")).roles("ADMIN").authorities("ROLE_ADMIN").build());
        return manager;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }

}
