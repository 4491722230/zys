package store.zys.zysstartersecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * @Author: zengyusheng
 * @Date: 2019/10/8 15:44
 * @Version 1.0
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    protected SecurityConfig() {
        super();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("ROLES");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
                    .antMatchers("/login.html").permitAll()
                    .anyRequest().authenticated()
                    .and()
               .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login")
                    .permitAll()
                    .and()
               .logout()
                    .permitAll();
    }
}
