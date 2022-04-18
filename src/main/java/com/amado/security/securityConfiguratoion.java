package com.amado.security;

import com.amado.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class securityConfiguratoion extends WebSecurityConfigurerAdapter {
    @Autowired
    userService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    private DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider  dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userService);
        dao.setPasswordEncoder(getPasscode());
        return dao;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/"
                ,"/index"
                ,"/initialize"
                ,"/shop"
                ,"/product/**"
                ,"/shop/**"
                ,"/categories/**"
                ,"/brand/**"
                ,"/register"
                ,"/forget"
                ,"/search"
                ,"/search/**"
                ,"/contact"
                ,"/h2-console"
                ,"/h2-console/**"
                ,"/css/**"
                ,"/fonts/**"
                ,"/img/**"
                ,"/js/**"
                ,"/scss/**")
                .permitAll()
                .and()
                .authorizeRequests().
                antMatchers("/h2-console/**").permitAll()
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**","/contact","/contact/**","/register","/register/**","/product/**")
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
                .and()

                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

    @Bean
    public PasswordEncoder getPasscode(){
        return NoOpPasswordEncoder.getInstance();
    }
}
