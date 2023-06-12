package com.example.first_project.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class security {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
//	 @Override
//	    protected void configure (AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userDetailsService);
//	    }

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery("SELECT ID, pass, true FROM user WHERE ID=?")
//				.authoritiesByUsernameQuery("SELECT u.ID, concat(\"ROLE_\", r.user_role)\r\n" + "FROM user_role ur \r\n"
//						+ "INNER JOIN user u \r\n" + "ON u.id = ur.ID_USER \r\n" + "INNER JOIN role r \r\n"
//						+ "ON r.ID = ur.ID_ROLE \r\n" + "WHERE u.ID= ?;")
//				.passwordEncoder(passwordEncoder());
//	}

/*	@SuppressWarnings("deprecation")*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
/*		return NoOpPasswordEncoder.getInstance();*/
	}
	
	@Bean
    // authentication
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("hach")
                .password(encoder.encode("hacheery"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("pwd1"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				// Quyền admin
//				.antMatchers("/admin/**")
//				// .antMatchers("/list")
//				.access("hasRole('ROLE_ADMIN')")
//				// Quyền User
//				.antMatchers("/user/**")
////			.antMatchers("/userPage/*","/profileOfStudent/*", "/classOfStudent/*")
//				.access("hasRole('ROLE_USER')")
//				.antMatchers("/*").permitAll()
//				.anyRequest()
//				.authenticated()
//				.and()
//				.formLogin()
//				.loginProcessingUrl("/doLogin")
//				.loginPage("/login")
//				.permitAll()
//				.passwordParameter("pass")
//				.usernameParameter("username")
//				.defaultSuccessUrl("/home")
//				.failureUrl("/login?error").and().logout()
//				.permitAll()
//				.logoutUrl("/logoutSuccess")
//				.logoutSuccessUrl("/login?logout=true")
//				.and()
//				.csrf().disable();
//	}

	// chưa mã hóa pass
}