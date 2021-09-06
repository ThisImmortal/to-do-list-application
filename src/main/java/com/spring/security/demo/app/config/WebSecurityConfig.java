package com.spring.security.demo.app.config;

import com.spring.security.demo.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(
                 "/register**",
                            "/register/**",
                            "/forgot-password**",
                            "/forgot-password/**",
                            "/webjars/**",
                            "/css/**",
                            "/img/**",
                            "/favicon.ico").permitAll().
                anyRequest().authenticated().
                and().
                formLogin().loginPage("/show-login-page").loginProcessingUrl("/login").
                permitAll().
                and().logout().logoutUrl("/logout").logoutSuccessUrl("/show-login-page").
                invalidateHttpSession(true).and().csrf().disable();




//        http.logout().logoutUrl("/user-logout").logoutSuccessUrl("/show-login-page").
//                invalidateHttpSession(true).deleteCookies("JSESSIONID");

    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**", "/img/**", "/favicon.ico");
//    }

    //    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        List<UserDetails> users = new ArrayList<>();
//        users.add(User.withDefaultPasswordEncoder().username("Zaur").password("1234").roles("USER").build());
//
//        return new InMemoryUserDetailsManager(users);
//    }
}
