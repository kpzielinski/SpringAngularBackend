package com.example.springangularbackend;

import com.example.springangularbackend.User.AppUser;
import com.example.springangularbackend.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringAngularBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAngularBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                AppUser appUser = new AppUser(name, name.toLowerCase() + "@domain.com");
                userRepository.save(appUser);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }

}
