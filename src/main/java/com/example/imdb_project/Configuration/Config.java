package com.example.imdb_project.Configuration;


import com.example.imdb_project.Repositories.ElasticLowClientImpl;
import com.example.imdb_project.Service.SearchService;
import com.example.imdb_project.Service.SearchServiceImpl;
import com.example.imdb_project.Service.UserEngine;
import com.example.imdb_project.Service.UserEngineImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync(proxyTargetClass = true)
public class Config implements AsyncConfigurer {


    @Bean
    public SearchService searchService(ElasticLowClientImpl searchEngine) {
        return new SearchServiceImpl(searchEngine);
    }

    @Bean
    public UserEngine userEngine (){
        return new UserEngineImpl();
    }

}
