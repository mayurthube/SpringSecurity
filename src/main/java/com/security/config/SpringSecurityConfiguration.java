package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	MyUserDetailsService userDetailsService;
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}*/
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic()
		.authenticationEntryPoint(authenticationEntryPoint);
//		super.configure(http);
	}	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("User").password("Password").roles("Admin");
//		auth.inMemoryAuthentication().withUser("Gayu").password("MightyJava").roles("Admin");
	}*/
	
	
	// Adding the roles
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService);
        /*auth.inMemoryAuthentication()
                .withUser("mayur")
                .password("mayur")
                .roles("admin_role")
                .and()
                .withUser("gayu")
                .password("gayu")
                .roles("student");*/
    }
  
    // Configuring the api
    // according to the roles.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    	/*http.authorizeRequests()
    	.antMatchers("/homePage").hasRole("admin_role")
    	.antMatchers("/details").hasAnyRole("admin_role","student")
    	.anyRequest().authenticated().and().httpBasic();*/
       /* http.
                httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/homePage").hasRole("admin_role")
                .antMatchers("/details").hasAnyRole("admin_role","student")
                .and()
                .formLogin();*/
    }
  
    // Function to encode the password
    // assign to the particular roles.
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
