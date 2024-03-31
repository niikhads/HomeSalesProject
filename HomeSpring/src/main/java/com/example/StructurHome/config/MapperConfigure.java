package com.example.StructurHome.config;

import com.example.StructurHome.mapper.HomeMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigure {
    @Bean
    public HomeMapper homeMapper(){
        return HomeMapper.INSTANCE;
    }
}
