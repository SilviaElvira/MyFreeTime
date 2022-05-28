package com.myfreetime.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.beans.factory.annotation.Autowired;

import com.myfreetime.service.EmpresaLoginServiceImpl;
import com.myfreetime.service.UsuarioLoginServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    UsuarioLoginServiceImpl usuarioLoginService;
    
    @Autowired
    EmpresaLoginServiceImpl empresaLoginService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
	        .antMatchers("/", "/login", "/registro-usuario", "/registro-empresa", "/resources/**", "/static/**","/webjars/**").permitAll()
	        .antMatchers("/actividades").access("hasRole('USER') or hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/actividades")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return this.bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	if(usuarioLoginService != null) {
    	auth.userDetailsService((UserDetailsService)usuarioLoginService).passwordEncoder((PasswordEncoder)passwordEncoder());
    	}
    	if(empresaLoginService != null) {
        	auth.userDetailsService((UserDetailsService)empresaLoginService).passwordEncoder((PasswordEncoder)passwordEncoder());
        	}
    } 
}
