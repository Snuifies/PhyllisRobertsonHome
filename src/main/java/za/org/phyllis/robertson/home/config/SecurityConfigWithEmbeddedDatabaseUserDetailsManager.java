package za.org.phyllis.robertson.home.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

/**
 *
 * @author snuif To activate this service uncomment the Configuration and the
 * EnableWewbSecuriity Annotations
 */
//@Configuration
//@EnableWebSecurity(debug = true)
public class SecurityConfigWithEmbeddedDatabaseUserDetailsManager {

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

    /**
     * Create a javax.sql.DataSource
     *
     * @return
     */
    @Bean(name = "dataSource")
    public static DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
            .build();
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    DataSource dataSource;

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

    @Bean
    @DependsOn({"dataSource"})
    public UserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        manager.createUser(User.builder().username("user").password(passwordEncoder.encode("pass")).roles("USER").authorities("ROLE_USER").build());
        manager.createUser(User.builder().username("admin").password(passwordEncoder.encode("pass")).roles("ADMIN").authorities("ROLE_ADMIN").build());
        return manager;
    }

}
