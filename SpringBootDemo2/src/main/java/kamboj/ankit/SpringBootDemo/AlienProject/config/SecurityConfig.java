package kamboj.ankit.SpringBootDemo.AlienProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * http.csrf().disable().authorizeRequests().antMatchers("/aliens/").hasAnyRole(
		 * "admin", "user") .and().formLogin();
		 * 
		 * http.csrf().disable().authorizeRequests().antMatchers("/aliens/*").hasAnyRole
		 * ("admin") .and().formLogin();
		 */
		http.csrf().disable().authorizeRequests().antMatchers("/aliens/").hasAnyRole("admin", "user").and()
				.authorizeRequests().antMatchers("/aliens/*").hasAnyRole("admin").and().formLogin();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		/*
		 * auth.inMemoryAuthentication().withUser("ankit").password("ankit").roles(
		 * "user");
		 * auth.inMemoryAuthentication().withUser("arun").password("arun").roles("user",
		 * "admin");
		 */

		auth.inMemoryAuthentication().withUser("ankit").password("ankit").roles("user").and().withUser("arun")
				.password("arun").roles("user", "admin");
	}

}
