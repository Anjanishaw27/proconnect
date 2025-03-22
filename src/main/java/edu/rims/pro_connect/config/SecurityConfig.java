package edu.rims.pro_connect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http.authorizeHttpRequests(request ->
        // request.requestMatchers("/client/login", "/style/**","/images/* ",
        // "/images/**","/admin/category")
        // .permitAll()
        //.requestmatcher("/admin/**")
       // .anyRequest().authenticated());
        // http.formLogin(form -> form.loginPage("/client/login"));
        // http.logout(Customizer.withDefaults());
        http.authorizeHttpRequests(request -> request.anyRequest().permitAll())
                .csrf(csrf -> csrf.disable()) // Disable CSRF
                .headers(headers -> headers.frameOptions().disable());
        ;
        return http.build();
    }
    //@Bean
    //passwordEncoder encoder(){
       // return new BCryptPasswordEncoder(12);
   // }
   //@Bean 
   //UserDetailsService detailsService(){
   //return(username)->{
   //User user=UserRepository.findByUserEmail(username)
   //.orElseThrow(()->new UsernameNotFoundException("UserNotFound"));
   //return org.springFramework.security.core.userdetails.User.builder()
   //.username(username)
   //.password(user.getUserPassword())
   //.roles(user.getUserRole().toString())
   //.build();
   //};
}
