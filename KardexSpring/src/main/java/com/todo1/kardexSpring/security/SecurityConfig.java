package com.todo1.kardexSpring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.todo1.kardexSpring.handlers.CustomAccesDeniedHandler;

@Configuration
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetails;

	@Bean
	public BCryptPasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}

	@Bean 
	public AccessDeniedHandler accesDeniedHandler() {
		return new CustomAccesDeniedHandler();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetails).passwordEncoder(passwordEnconder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/", "/auth/**", "/h2-console/**").permitAll().anyRequest().authenticated()
		
		.and().formLogin()
				.loginProcessingUrl("/auth/login-post").permitAll()
				//.defaultSuccessUrl("/private/index", true)
				.defaultSuccessUrl("/", true)

				.failureUrl("/auth/login?error=true")
				.loginPage("/auth/login")
				.usernameParameter("nit")
				.passwordParameter("password")
				
		.and().exceptionHandling()
			.accessDeniedHandler(accesDeniedHandler())
			
		.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutUrl("/logout")
				.logoutSuccessUrl("/?logout=succes")
				.deleteCookies("JSESSIONID");
 

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

}
