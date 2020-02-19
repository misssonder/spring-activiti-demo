package com.activiti.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity//启动security过滤器链
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
    @Override//<security:authentication-manager>配置
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("123")
                .password(new BCryptPasswordEncoder().encode("123"))
                .authorities("USER");
    }

    @Override//<security:http>配置
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/notLogin").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/user/*")
                .fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/user/notLogin")
                .and()
                .logout().logoutUrl("user/logout")
                .and().csrf().disable();
    }
}
