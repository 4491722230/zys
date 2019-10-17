package store.zys.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import store.zys.security.filter.JwtAuthenticationFilter;
import store.zys.security.filter.JwtLoginFilter;
import store.zys.security.service.UserDetailsServiceImpl;

/**
 * @Author: zengyusheng
 * @Date: 2019/10/14 10:37
 * @Version 1.0
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/user/hello").permitAll()
                .antMatchers("/user/logout").permitAll()
                .antMatchers("/login.html").permitAll()
                .antMatchers("error.html").permitAll()
                .antMatchers("/role/list").hasRole("admin")
                .anyRequest().authenticated()
//                .anyRequest()
//                .access("@rbacauthorityservice.hasPermission(request,authentication)")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successForwardUrl("/swagger-ui.html")
                .failureForwardUrl("/error.html")
                .and()
                .addFilter(new JwtLoginFilter(authenticationManager()))
                .addFilter(new JwtAuthenticationFilter(authenticationManager()));
//               .exceptionHandling().accessDeniedHandler(new RestAuthenticationAccessDeniedHandler())
//                .authenticationEntryPoint(new AuthEntryPoint());
    }
}
