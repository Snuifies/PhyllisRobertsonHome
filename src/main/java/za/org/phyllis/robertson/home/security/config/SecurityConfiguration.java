package za.org.phyllis.robertson.home.security.config;

import javax.annotation.Resource;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import za.org.phyllis.robertson.home.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static final String ADMIN = "ADMIN";
    private static final String USER = "USER";

    @Resource(name = "userDetailsService")
    private UserDetailsService userDetailsService;

    @Bean("passwordEncoder")
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean("webSecurityCustomizer")
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }

    @Bean("authenticationProvider")
    @DependsOn({"userDetailsService", "passwordEncoder"})
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean("securityFilterChain")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        try {
            http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/rest/all").permitAll()
                .antMatchers("/rest/version").permitAll()
                .antMatchers("/rest/user").hasAnyAuthority(ADMIN, USER)
                .antMatchers("/rest/admin").hasAuthority(ADMIN)
                .antMatchers("/javax.faces.resource/**").permitAll()
                .antMatchers("/residence/**").hasAnyAuthority(ADMIN, USER)
                .antMatchers("/admin/**").hasAuthority(ADMIN)
                .and().formLogin()
                .loginPage("/login.jsf")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/residence/home.jsf", true)
                .failureUrl("/login.jsf?error=true")
                .and().logout()
                .logoutSuccessUrl("/login.jsf")
                .deleteCookies("JSESSIONID")
                .and().csrf().disable()
                .authenticationProvider(authenticationProvider()) 
//                                .authenticationManager(authenticationManager);
                ;
            return http.build();
        } catch (Exception ex) {
            throw new BeanCreationException("Wrong spring security configuration", ex);
        }
    }

}
