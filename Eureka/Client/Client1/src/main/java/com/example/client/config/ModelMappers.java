package com.example.client.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappers {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
