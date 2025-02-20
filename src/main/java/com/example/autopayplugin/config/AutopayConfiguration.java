package com.example.autopayplugin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.autopayplugin.constants.Constants.AUTOPAY_OBJECT_MAPPER;

@Configuration
public class AutopayConfiguration {

    @Bean(AUTOPAY_OBJECT_MAPPER)
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        return objectMapper;
    }
}
