package za.org.phyllis.robertson.home.security.config;

import javax.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = "ADMIN";
    private static final String USER = "USER";

    @Resource(name = "userDetailsService")
    private UserDetailsService userDetailsService;

    @Bean("passwordEncoder")
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean("authenticationProvider")
    @DependsOn({"userDetailsService", "passwordEncoder"})
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

//    @Bean("authenticationSuccessHandler")
//    public CustomAuthenticationSuccessHandler authenticationSuccessHandler() {
//        return new CustomAuthenticationSuccessHandler();
//    }
    @Override
    @DependsOn("authenticationProvider")
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

    @Override
//    @DependsOn("authenticationSuccessHandler")
    protected void configure(HttpSecurity http) throws Exception {
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
//            .authenticationDetailsSource(authenticationDetailsSource)
            .failureUrl("/login.jsf?error=true")
//            .failureHandler(authenticationFailureHandler())
            .and().logout()
            .logoutSuccessUrl("/login.jsf")
//            .logoutUrl("/logout")
//            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
//            .logoutSuccessHandler(logoutSuccessHandler())
            .and().csrf().disable();
    }
}
