package com.proyecto.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("courseMapper")
    public ModelMapper modelMapper(){
       ModelMapper mapper=new ModelMapper();
       return mapper;
    }

    @Bean("studentMapper")
    public ModelMapper studentMapper(){
        ModelMapper mapper=new ModelMapper();
        return mapper;
    }

    @Bean("enrollmentMapper")
    public ModelMapper enrollmentMapper(){
        ModelMapper mapper=new ModelMapper();
        return mapper;
    }

}
