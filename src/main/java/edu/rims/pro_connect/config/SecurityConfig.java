package edu.rims.pro_connect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.rims.pro_connect.constant.UserType;
import edu.rims.pro_connect.entity.User;
import edu.rims.pro_connect.repository.UserRepository;

@Configuration
public class SecurityConfig {
    @Autowired
    private UserRepository userRepository;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                request -> request
                        .requestMatchers("/client/sign_in", "/style/**", "/images/*", "/script/**",
                                "/category/category", "/freelancer/freelancer", "/client/home",
                                "/category/category/search", "/freelancer/freelancer/search", "/client/howitworks",
                                "/client/solution", "/client/project","/client/myproject",
                                "/client/contact", "/client/category/project", "/client/sign_up", "/freelancer/sign_up")
                        .permitAll()
                        // .requestMatchers("/admin/**").hasRole(UserType.ADMIN.toString())
                        // .requestMatchers("/freelancer/**").hasRole(UserType.FREELANCER.toString())
                        // .requestMatchers("/client/**").hasRole(UserType.CLIENT.toString())
                        .anyRequest().authenticated());
        http.formLogin(form -> form.loginPage("/client/sign_in").defaultSuccessUrl("/client/home"));
        http.logout(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    UserDetailsService detailsService() {
        return (username) -> {
            User user = userRepository.findByUserEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("userNotFound"));

            return org.springframework.security.core.userdetails.User.builder()
                    .username(username)
                    .password(user.getUserPassword())
                    .roles(user.getUserType().toString())
                    .build();
        };
    }
}