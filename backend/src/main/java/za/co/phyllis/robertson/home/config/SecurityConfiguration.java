package za.co.phyllis.robertson.home.config;

import javax.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

	@Override
	@DependsOn("authenticationProvider")
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.authenticationProvider(authenticationProvider());
	}

	@Override
	@DependsOn("userDetailsService")
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/all", "/version", "/message").permitAll()
			.antMatchers("/products").permitAll()
			.antMatchers("/user/**").permitAll()//.hasAnyAuthority(ADMIN, USER)
			.antMatchers("/admin").hasAuthority(ADMIN)
			.antMatchers("/residence/**").hasAnyAuthority(ADMIN, USER)
			.antMatchers("/admin/**").hasAuthority(ADMIN)
			.and().rememberMe().userDetailsService(userDetailsService)
			.and().formLogin().permitAll()
			.and().logout().permitAll()
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID");
		http.csrf().disable();
	}
}
