package com.example.imdb_project.Service;

import com.example.imdb_project.Repositories.ElasticLowClientImpl;
import net.minidev.json.parser.ParseException;

import java.io.IOException;

public class SearchServiceImpl implements SearchService{

    private final ElasticLowClientImpl elasticLowClient;

    public SearchServiceImpl(ElasticLowClientImpl elasticLowClient) {
        this.elasticLowClient = elasticLowClient;
    }


    @Override
    public String search(String query) throws IOException, ParseException, InterruptedException {
        return elasticLowClient.search();
    }
}
