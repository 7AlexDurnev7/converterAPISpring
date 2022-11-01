package com.example.converterapispring;

import com.example.converterapispring.logic.ISolver;
import com.example.converterapispring.logic.SolverImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // бин для решателя
    @Bean
    ISolver solver() {
        return new SolverImpl();
    }
}
