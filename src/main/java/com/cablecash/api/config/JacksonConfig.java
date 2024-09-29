package com.cablecash.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        SimpleModule module = new SimpleModule();
        module.addSerializer(Date.class, new com.fasterxml.jackson.databind.ser.std.DateSerializer(false, new SimpleDateFormat("dd/MM/yyyy")));
        module.addDeserializer(Date.class, new com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer());
        objectMapper.registerModule(module);

        objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        return objectMapper;
    }
}