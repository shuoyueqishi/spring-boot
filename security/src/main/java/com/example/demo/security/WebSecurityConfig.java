package com.example.demo.security;

import com.example.demo.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   /* @Bean
    public CustomUserService customUserService(){
        return new CustomUserService();
    }*/
   @Autowired
   private CustomUserService customUserService;

    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.formLogin().failureUrl("/login?error").defaultSuccessUrl("/ayUser/test").permitAll();
        super.configure(httpSecurity);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{

        auth.userDetailsService(customUserService);

        //auth.inMemoryAuthentication().withUser("许立涛").password("123456").roles("ADMIN")
         //       .and().withUser("胡丹丹").password("123456").roles("USER");

    }
}
